package com.tienda.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tienda.entity.Rol;
import com.tienda.repository.UserRepository;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	private static final Log LOG = LogFactory.getLog(UserService.class);

	@Override
	public UserDetails loadUserByUsername(String documentNum) throws UsernameNotFoundException {
		LOG.info("METHOD: loadUserByUsername() -- PARAM: " + documentNum);
		com.tienda.entity.User user = userRepository.findByDocumentNum(documentNum);
		if (user != null) {
			List<GrantedAuthority> authorities = buildAuthorities(user.getRolList());
			LOG.info("User found: " + user.toString() + " Authorities: " + authorities);
			return buildUser(user, authorities);
		}

		throw new UsernameNotFoundException("No se encuentra el usuario con numero de documento: " + documentNum);
	}

	private User buildUser(com.tienda.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getDocumentNum(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(List<Rol> roles) {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		for (Rol rol : roles) {
			auths.add(new SimpleGrantedAuthority(rol.getId()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}
	
	public List<com.tienda.entity.User> listAllUsers(){
		LOG.info("METHOD: listAllUsers()");
		return userRepository.findAll();
	}
	
	public com.tienda.entity.User findUserById(Integer id) {
		LOG.info("METHOD: findUserById() -- PARAMS: " + id);
		return userRepository.findById(id);
	}
	
	public void removeUser(Integer id) {
		LOG.info("METHOD: removeUser() -- PARAMS: " + id);
		com.tienda.entity.User user = findUserById(id);
		if(user != null) {
			userRepository.delete(id);
		}
	}
	
	public com.tienda.entity.User addClient(com.tienda.entity.User user){
		LOG.info("METHOD: addClient() -- PARAMS: " + user.toString());
		com.tienda.entity.User foundUser = userRepository.findByDocumentNum(user.getDocumentNum());
		if(foundUser == null) {
			user.setRolList(new ArrayList<Rol>());
			user.getRolList().add(new Rol("ROLE_CLIENT"));
			userRepository.save(user);
		}else {
			LOG.error("El numero de documento" + user.getDocumentNum()+ " ya se encuentra registrado.");
		}
		
		return user;
	}
}

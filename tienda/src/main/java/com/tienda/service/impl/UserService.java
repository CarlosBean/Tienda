package com.tienda.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
			auths.add(new SimpleGrantedAuthority(rol.getDescription()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}
}

package com.tienda.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable>{
	
	public abstract User findByDocumentNum(String documentNum);
}

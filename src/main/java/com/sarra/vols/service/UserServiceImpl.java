package com.sarra.vols.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sarra.vols.entities.Role;
import com.sarra.vols.entities.User;
import com.sarra.vols.repos.RoleRepository;
import com.sarra.vols.repos.UserRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public User addRoleToUser(String username, String rolename) {
		User usr = userRepository.findByUsername(username);
		Role role = roleRepository.findByRole(rolename);
		usr.getRoles().add(role);
		//userRepository.save(usr); // c p necessaire de faire ca puisque on a transactional 
		return usr;
		}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
		
	}

	

}

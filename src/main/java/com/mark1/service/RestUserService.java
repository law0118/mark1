package com.mark1.service;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mark1.entity.core.LogInformation;
import com.mark1.entity.core.User;
import com.mark1.repository.core.UserRepository;

@Service
@Transactional(readOnly = true)
public class RestUserService implements UserService {

	@Inject
	private UserRepository userRepository;
	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUsername(username);
	}

	@Override
	public List<User> findUserByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findUserByName(name, LogInformation.ACTIVE);
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		user.setId(0);
		
		return userRepository.save(user);
	}

	@Override
	@Transactional
	public User updateUser(String username, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		getUserByUsername(username).getLogInformation().setActiveFlag(LogInformation.INACTIVE);
	}

}

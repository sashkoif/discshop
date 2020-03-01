package com.test.discshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.discshop.domain.User;
import com.test.discshop.repository.UserRepository;

@Service
public class UserService{
	@Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findById(Long id) {
		return userRepository.findById(id).get();
	}
}

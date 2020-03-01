package com.test.discshop.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.test.discshop.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

	Optional<User> findById(Long id);
}
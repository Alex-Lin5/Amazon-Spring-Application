package com.revature.AmazonSpringApp.repository;

import com.revature.AmazonSpringApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    // query creation from method name
    Optional<User> findByEmail(String email);
}

package com.revature.AmazonSpringApp.repository;

import com.revature.AmazonSpringApp.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileDAO extends JpaRepository<Profile, Integer> {
}

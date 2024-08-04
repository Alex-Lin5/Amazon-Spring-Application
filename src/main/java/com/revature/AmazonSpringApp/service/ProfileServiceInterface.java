package com.revature.AmazonSpringApp.service;

import com.revature.AmazonSpringApp.entity.Profile;

public interface ProfileServiceInterface {
    Profile getProfile();
    Profile editProfile(Profile p);
    Profile createProfile(Profile p);
    Profile removeProfile(Profile p);
}

package com.revature.AmazonSpringApp.service;

import com.revature.AmazonSpringApp.entity.Product;
import com.revature.AmazonSpringApp.entity.Profile;
import com.revature.AmazonSpringApp.repository.ProfileDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProfileService implements ProfileServiceInterface{
    @Autowired
    private ProfileDAO profileDAO;
    
    @Override
    public Profile getProfile(Profile p) {
        Optional<Profile> profileFind = profileDAO.findById(p.getId());
        return profileFind.orElse(null);
    }

    @Override
    public Profile editProfile(Profile p) {
        Optional<Profile> profileFind = profileDAO.findById(p.getId());
        if(profileFind.isPresent()){
            profileDAO.save(p);
            return p;
        }
        return null;
    }

    @Override
    public Profile createProfile(Profile p) {
        return profileDAO.save(p);
    }

    @Override
    public Profile removeProfile(Profile p) {
        Optional<Profile> profileFind = profileDAO.findById(p.getId());
        if(profileFind.isPresent()){
            profileDAO.delete(p);
            return profileFind.get();
        }
        return null;
    }
}

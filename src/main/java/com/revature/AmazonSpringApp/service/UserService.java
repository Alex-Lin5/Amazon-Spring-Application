package com.revature.AmazonSpringApp.service;

import com.revature.AmazonSpringApp.entity.Cart;
import com.revature.AmazonSpringApp.entity.Profile;
import com.revature.AmazonSpringApp.entity.User;
import com.revature.AmazonSpringApp.repository.CartDao;
import com.revature.AmazonSpringApp.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService implements UserServiceInterface{
    @Autowired
    UserDao userDao;
    @Autowired
    CartDao cartDao;

    @Override
    public User register(User user) {
        if(userDao.findByEmail(user.getEmail()).isEmpty())
            return userDao.save(user);;
        return null;
    }

    @Override
    public User login(User user) {
        String otp = "";
        Optional<User> findUser = userDao.findByEmail(user.getEmail());

        if(findUser.isPresent()){
            if(findUser.get().getPassword().equals(user.getPassword())){
                // generate otp
                otp = String.valueOf((int) (Math.random()*100000));
                user.setOtp(otp);
                // send email

                // ---------------
                verify(user, otp);
            }
            return findUser.get();
        }
        return null;
    }

    @Override
    public String verify(User user, String otp) {
        // verify otp
        if(otp.equals(user.getOtp())){
            // return token
            String token = String.valueOf((int) (Math.random()*10000000));
            user.setToken(token);
            return token;
        }
        return null;
    }

    @Override
    public void logout() {

    }

    @Override
    public void block(User user) {

    }

    @Override
    public void unblock(User user) {

    }

    @Override
    public Cart getCart(User user) {
//        return cartDao.findCart(user.getCartId().getId());
        return null;
    }

}

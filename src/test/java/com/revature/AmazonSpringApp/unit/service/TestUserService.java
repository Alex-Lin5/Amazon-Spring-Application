package com.revature.AmazonSpringApp.unit.service;

import com.revature.AmazonSpringApp.repository.CartDao;
import com.revature.AmazonSpringApp.repository.UserDao;
import com.revature.AmazonSpringApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserService.class)
public class TestUserService {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDao userDao;
    @MockBean
    private CartDao cartDao;

    @Test
    void userRegisterSuccess(){}
}

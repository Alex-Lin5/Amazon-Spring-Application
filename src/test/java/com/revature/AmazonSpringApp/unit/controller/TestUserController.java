package com.revature.AmazonSpringApp.unit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.revature.AmazonSpringApp.controller.UserController;
import com.revature.AmazonSpringApp.entity.User;
import com.revature.AmazonSpringApp.service.CartService;
import com.revature.AmazonSpringApp.service.ProfileService;
import com.revature.AmazonSpringApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class TestUserController {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
    @MockBean
    private ProfileService profileService;
    @MockBean
    private CartService cartService;

    @Test
    void userRegisterSuccess() throws Exception{
        User userSent = new User(0, "user1@test.com", "password1", false);
        User userReturn = new User(1, "user1@test.com", "password1", false);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String sentJson = ow.writeValueAsString(userSent);

        when(userService.register(userSent)).thenReturn(userReturn);
        this.mockMvc.perform(MockMvcRequestBuilders
                    .post("/user/register")
                    .content(sentJson)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.isAdmin").value(false))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("user1@test.com"));
    }
    @Test
    void userRegisterFail() throws Exception{
        User userSent = new User(0, "user1@test.com", null, false);
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String sentJson = ow.writeValueAsString(userSent);

        when(userService.register(userSent)).thenReturn(null);
        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/user/register")
                        .content(sentJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string(""));
    }

}

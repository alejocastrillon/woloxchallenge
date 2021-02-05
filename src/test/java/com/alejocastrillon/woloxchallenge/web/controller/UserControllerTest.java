package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.services.UserService;
import com.alejocastrillon.woloxchallenge.web.dto.UserDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserControllerTest {

    @Mock
    private UserService service;

    @InjectMocks
    private UserController controller;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getUsers() {
        UserDto user = new UserDto();
        user.setId(1);
        UserDto[] users = { user };
        Mockito.when(service.getUsers()).thenReturn(users);
        ResponseEntity<UserDto[]> result = controller.getUsers();
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
    }
}
package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.web.dto.UserDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserServiceImpl service;

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getUsers() {
        ReflectionTestUtils.setField(service, "baseUrl", baseUrl);
        UserDto user = new UserDto();
        user.setId(1);
        UserDto[] users = { user };
        Mockito.when(restTemplate.getForObject(baseUrl + "/users", UserDto[].class)).thenReturn(users);
        UserDto[] usersService = service.getUsers();
        Assert.assertNotNull(usersService);
        Assert.assertTrue(usersService.length > 0);
    }

    @Test
    public void getUser() {
        ReflectionTestUtils.setField(service, "baseUrl", baseUrl);
        UserDto user = new UserDto();
        user.setId(1);
        Mockito.when(restTemplate.getForObject(baseUrl + "/users/" + user.getId(), UserDto.class)).thenReturn(user);
        UserDto userService = service.getUser(user.getId());
        Assert.assertNotNull(userService);
        Assert.assertEquals(user.getId(), userService.getId());
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.services.UserService;
import com.alejocastrillon.woloxchallenge.web.dto.UserDto;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * User service.
 *
 * @author alejandroutp
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * Rest template instance.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Base url for external Rest service.
     */
    @Value("${external.base.url}")
    private String baseUrl;

    /**
     * Gets all the users.
     *
     * @return User list
     */
    @Override
    public List<UserDto> getUsers() {
        return Arrays.asList(restTemplate
                .getForObject(baseUrl + "/users", UserDto[].class));
    }

}

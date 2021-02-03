/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.services.UserService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
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

    /**
     * Gets the information about a specific user.
     *
     * @param userId Identifier of the user whose we want
     * @throws NotFoundException In case that the user is not found
     * @return User information
     */
    @Override
    public UserDto getUser(Integer userId) {
        try {
            return restTemplate.getForObject(baseUrl + "/users/" + userId,
                    UserDto.class);
        } catch (RuntimeException e) {
            throw new NotFoundException("No user found with the identifier: "
                    + userId);
        }
    }

}

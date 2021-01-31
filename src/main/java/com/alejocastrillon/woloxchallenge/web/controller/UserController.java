/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.services.UserService;
import com.alejocastrillon.woloxchallenge.web.dto.UserDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User service controller
 *
 * @author alejandroutp
 */
@RestController
@RequestMapping("${api.base.url}/users")
@ApiOperation(value = "User service controller")
public class UserController {

    /**
     * User service instance.
     */
    @Autowired
    private UserService service;

    /**
     * Returns all the users obtained in the service.
     *
     * @return User list
     */
    @ApiOperation(value = "Returns all the users obtained in the service",
            response = UserDto.class, responseContainer = "List<>",
            code = 200)
    @GetMapping()
    public ResponseEntity getUsers() {
        return new ResponseEntity(service.getUsers(), HttpStatus.OK);
    }

}

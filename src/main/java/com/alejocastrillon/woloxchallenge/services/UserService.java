/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services;

import java.util.List;
import com.alejocastrillon.woloxchallenge.web.dto.UserDto;

/**
 * User service interface.
 *
 * @author alejandroutp
 */
public interface UserService {

    /**
     * Gets all the users.
     *
     * @return User list
     */
    List<UserDto> getUsers();

}

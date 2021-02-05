/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.services.AlbumService;
import com.alejocastrillon.woloxchallenge.web.dto.AlbumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.alejocastrillon.woloxchallenge.services.UserService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;

/**
 * Implementation of album service.
 *
 * @author alejandroutp
 */
@Service
public class AlbumServiceImpl implements AlbumService {

    /**
     * Rest Template instance.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * User service instance.
     */
    @Autowired
    private UserService userService;

    /**
     * External rest service base url.
     */
    @Value("${external.base.url}")
    private String baseUrl;

    /**
     * Not found exception message.
     */
    private static final String NOT_FOUND_EXCEPTION_MESSAGE = "No album was found with the identifier: ";

    /**
     * Gets all the albums.
     *
     * @return Album list
     */
    @Override
    public AlbumDto[] getAlbums() {
        return restTemplate.getForObject(baseUrl + "/albums", AlbumDto[].class);
    }

    /**
     * Gets the albums created by an user.
     *
     * @param userId User ID
     * @return Album list
     */
    @Override
    public AlbumDto[] getAlbumsByUser(Integer userId) {
        userService.getUser(userId);
        return restTemplate.getForObject(baseUrl + "/albums?userId=" + userId, AlbumDto[].class);

    }

    /**
     * Gets a specific album information
     *
     * @param albumId Album identifier
     * @throws NotFoundException No album was found with the identifier
     * @return Album information
     */
    @Override
    public AlbumDto getAlbum(Integer albumId) {
        try {
            return restTemplate.getForObject(baseUrl + "/albums/" + albumId, AlbumDto.class);
        } catch (RuntimeException e) {
            throw new NotFoundException(NOT_FOUND_EXCEPTION_MESSAGE + albumId);
        }
    }

}

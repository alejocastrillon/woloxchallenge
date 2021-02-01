/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.services.AlbumService;
import com.alejocastrillon.woloxchallenge.web.dto.AlbumDto;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.alejocastrillon.woloxchallenge.model.repository.SharedAlbumRepository;

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
     * Shared album repository instance.
     */
    @Autowired
    private SharedAlbumRepository repository;

    /**
     * Base url of externa rest service.
     */
    @Value("${external.base.url}")
    private String baseUrl;

    /**
     * Gets all the albums.
     *
     * @return Album list
     */
    @Override
    public List<AlbumDto> getAlbums() {
        return Arrays.asList(restTemplate.getForObject(baseUrl + "/albums",
                AlbumDto[].class));
    }

    /**
     * Gets the albums created by an user.
     *
     * @param userId User ID
     * @return Album list
     */
    @Override
    public List<AlbumDto> getAlbumsByUser(Integer userId) {
        if (userId != null) {
            return Arrays.asList(restTemplate.getForObject(baseUrl
                    + "/albums?userId=" + userId, AlbumDto[].class));
        }
        return null;
    }

}

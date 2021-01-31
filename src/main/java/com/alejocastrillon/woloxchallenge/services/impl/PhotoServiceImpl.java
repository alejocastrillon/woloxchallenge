/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.impl;

import org.springframework.stereotype.Service;
import com.alejocastrillon.woloxchallenge.services.PhotoService;
import com.alejocastrillon.woloxchallenge.services.AlbumService;
import com.alejocastrillon.woloxchallenge.web.dto.PhotoDto;
import com.alejocastrillon.woloxchallenge.web.dto.AlbumDto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

/**
 * Photo service.
 *
 * @author alejandroutp
 */
@Service
public class PhotoServiceImpl implements PhotoService {

    /**
     * Rest template instance.
     */
    @Autowired
    private RestTemplate restTemplate;
    /**
     * Album service instance.
     */
    @Autowired
    private AlbumService albumService;
    /**
     * Base url for rest template.
     */
    @Value("${external.base.url}")
    private String baseUrl;

    /**
     * Gets all the photos.
     *
     * @return Photo list
     */
    @Override
    public List<PhotoDto> getPhotos() {
        return Arrays.asList(restTemplate.getForObject(baseUrl + "/photos",
                PhotoDto[].class));
    }

    /**
     * Gets all the photos associated to a user.
     *
     * @param userId User ID
     * @return Photo list
     */
    @Override
    public List<PhotoDto> getPhotosByUser(Integer userId) {
        List<PhotoDto> photosByUser = null;
        if (userId != null) {
            List<AlbumDto> albumsByUser = albumService.getAlbumsByUser(userId);
            if (albumsByUser != null && !albumsByUser.isEmpty()) {
                photosByUser = new ArrayList<>();
                for (AlbumDto album : albumsByUser) {
                    photosByUser.addAll(Arrays.asList(restTemplate.getForObject(
                            baseUrl + "/photos?albumId=" + album.getId(),
                            PhotoDto[].class)));
                }
            }
        }
        return photosByUser;
    }

}

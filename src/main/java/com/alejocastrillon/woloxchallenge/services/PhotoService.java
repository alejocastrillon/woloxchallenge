/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services;

import java.util.List;
import com.alejocastrillon.woloxchallenge.web.dto.PhotoDto;

/**
 * Photo service interface.
 *
 * @author alejandroutp
 */
public interface PhotoService {

    /**
     * Gets all the photos.
     *
     * @return Photo list
     */
    List<PhotoDto> getPhotos();

    /**
     * Gets all the photos associated to a user.
     *
     * @param userId User ID
     * @return Photo list
     */
    List<PhotoDto> getPhotosByUser(Integer userId);
}

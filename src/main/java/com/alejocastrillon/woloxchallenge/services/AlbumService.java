/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services;

import java.util.List;
import com.alejocastrillon.woloxchallenge.web.dto.AlbumDto;

/**
 * Albums service interface.
 *
 * @author alejandroutp
 */
public interface AlbumService {

    /**
     * Gets all the albums.
     *
     * @return Album list
     */
    List<AlbumDto> getAlbums();

    /**
     * Gets the albums created by a user.
     *
     * @param userId User ID
     * @return Album list
     */
    List<AlbumDto> getAlbumsByUser(Integer userId);

}

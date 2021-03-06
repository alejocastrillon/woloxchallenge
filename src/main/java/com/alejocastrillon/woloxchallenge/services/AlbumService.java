/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services;

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
    AlbumDto[] getAlbums();

    /**
     * Gets the albums created by a user.
     *
     * @param userId User ID
     * @return Album list
     */
    AlbumDto[] getAlbumsByUser(Integer userId);

    /**
     * Gets a specific album information
     *
     * @param id Album identifier
     * @return Album information
     */
    AlbumDto getAlbum(Integer id);

}

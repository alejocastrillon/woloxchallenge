/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services;

import com.alejocastrillon.woloxchallenge.web.dto.SharedAlbumDto;
import java.util.List;

/**
 * Shared albums service interface.
 *
 * @author alejandroutp
 */
public interface SharedAlbumService {

    /**
     * Persist the information of the shared album.
     *
     * @param album Album information
     * @return Album information
     */
    SharedAlbumDto saveAlbumShared(SharedAlbumDto album);

    /**
     * Gets the persisted information about the shared albums.
     *
     * @return List of shared albums
     */
    List<SharedAlbumDto> getSharedAlbums();

}

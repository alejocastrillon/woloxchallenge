/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services;

import com.alejocastrillon.woloxchallenge.web.dto.PermissionUserSharedAlbumDto;
import java.util.List;

/**
 * Service interface of permissions given to a user in an album.
 *
 * @author alejandroutp
 */
public interface PermissionUserSharedAlbumService {

    /**
     * Persist the information between an user and an album with its respective
     * permissions.
     *
     * @param permission Permission information
     * @return Persisted permission information
     */
    PermissionUserSharedAlbumDto savePermission(
            PermissionUserSharedAlbumDto permission);

    /**
     * Gets the users associated to a determinate album with an specific
     * permission associated.
     *
     * @param albumId Album identificator
     * @param permission Permission name
     * @return List of permission with users
     */
    List<PermissionUserSharedAlbumDto> getUsersWithPermissionInAlbum(
            Integer albumId, String permission);

}

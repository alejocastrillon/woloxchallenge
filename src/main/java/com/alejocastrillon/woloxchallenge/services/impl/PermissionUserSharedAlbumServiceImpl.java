/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.web.dto.PermissionUserSharedAlbumDto;
import com.alejocastrillon.woloxchallenge.model.entity.PermissionUserSharedAlbum;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alejocastrillon.woloxchallenge.model.repository.PermissionUserSharedAlbumRepository;
import com.alejocastrillon.woloxchallenge.services.PermissionUserSharedAlbumService;

/**
 * Service of permissions given to a user in an album
 *
 * @author alejandroutp
 */
@Service
public class PermissionUserSharedAlbumServiceImpl
        implements PermissionUserSharedAlbumService {

    /**
     * Repository instance of permissions given to a user on an album.
     */
    @Autowired
    private PermissionUserSharedAlbumRepository repository;

    /**
     * Model mapper instance.
     */
    private final ModelMapper mapper = new ModelMapper();

    /**
     * Persist the information between an user and an album with its respective
     * permissions.
     *
     * @param permission Permission information
     * @return Persisted permission information
     */
    @Override
    public PermissionUserSharedAlbumDto savePermission(
            PermissionUserSharedAlbumDto permission) {
        if (isValidPermissions(permission)) {
            return mapper.map(repository.save(mapper.map(permission,
                    PermissionUserSharedAlbum.class)),
                    PermissionUserSharedAlbumDto.class);
        }
        return null;
    }

    /**
     * Determines if the permission information is valid to be persisted.
     *
     * @param permission Permission information
     * @return Status of the action
     */
    private boolean isValidPermissions(
            PermissionUserSharedAlbumDto permission) {
        return permission != null && permission.getUserId() != null
                && permission.getSharedAlbumId() != null;
    }

    /**
     * Gets the users associated to a determinate album with an specific
     * permission associated.
     *
     * @param albumId Album identificator
     * @param permission Permission name
     * @return List of permission with users
     */
    @Override
    public List<PermissionUserSharedAlbumDto> getUsersWithPermissionInAlbum(
            Integer albumId, String permission) {
        if (albumId != null && permission != null) {
            if (permission.equalsIgnoreCase("can_read")) {
                return parseList(repository
                        .findBySharedAlbum_IdAndCanReadIsTrue(albumId));
            } else if (permission.equalsIgnoreCase("can_write")) {
                return parseList(repository
                        .findBySharedAlbum_IdAndCanWriteIsTrue(albumId));
            }
        }
        return null;
    }

    /**
     * Converts an entity permission list to a dto permission list.
     *
     * @param permissions List of permissions
     * @return List of permissions
     */
    private List<PermissionUserSharedAlbumDto> parseList(
            List<PermissionUserSharedAlbum> permissions) {
        List<PermissionUserSharedAlbumDto> parsed = null;
        if (permissions != null && !permissions.isEmpty()) {
            parsed = new ArrayList<>();
            for (PermissionUserSharedAlbum permission : permissions) {
                parsed.add(mapper.map(permission,
                        PermissionUserSharedAlbumDto.class));
            }
        }
        return parsed;
    }

}

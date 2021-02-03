/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.model.entity.EPermission;
import com.alejocastrillon.woloxchallenge.web.dto.SharedAlbumDto;
import com.alejocastrillon.woloxchallenge.model.entity.SharedAlbum;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alejocastrillon.woloxchallenge.model.repository.SharedAlbumRepository;
import com.alejocastrillon.woloxchallenge.services.AlbumService;
import com.alejocastrillon.woloxchallenge.services.SharedAlbumService;
import com.alejocastrillon.woloxchallenge.services.UserService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Shared albums service.
 *
 * @author alejandroutp
 */
@Service
public class SharedAlbumServiceImpl implements SharedAlbumService {

    /**
     * Shared albums repository instance.
     */
    @Autowired
    private SharedAlbumRepository repository;
    /**
     * Album service instance.
     */
    @Autowired
    private AlbumService albumService;
    /**
     * User service instance.
     */
    @Autowired
    private UserService userService;
    /**
     * Model mapper instance.
     */
    private final ModelMapper mapper = new ModelMapper();

    /**
     * Persist the information of the shared album.
     *
     * @param album Album information
     * @return Album information
     */
    @Override
    public SharedAlbumDto saveAlbumShared(SharedAlbumDto album) {
        if (isValidAlbum(album)) {
            return mapper.map(repository.save(mapper.map(album,
                    SharedAlbum.class)), SharedAlbumDto.class);
        }
        return null;
    }

    /**
     * Determines if the shared album information is valid to be persisted.
     *
     * @param album Shared album information
     * @return Status of the action
     */
    private boolean isValidAlbum(SharedAlbumDto album) {
        return album != null && album.getAlbumId() != null
                && albumService.getAlbum(album.getAlbumId()) != null
                && album.getUserId() != null
                && userService.getUser(album.getUserId()) != null
                && isValidPermission(album.getPermission());
    }

    /**
     * Checks if the permissions added to album exists.
     *
     * @param permissions Set of permission
     * @throws NotFoundException The permission does not exist
     * @return Validation status
     */
    private boolean isValidPermission(Set<String> permissions) {
        permissions.forEach(permission -> {
            try {
                EPermission.valueOf(permission);
            } catch (RuntimeException e) {
                throw new NotFoundException(permission + " permission does not"
                        + " exist");
            }
        });
        return true;
    }

    /**
     * Gets the persisted information about the shared albums.
     *
     * @return List of shared albums
     */
    @Override
    public List<SharedAlbumDto> getSharedAlbums() {
        List<SharedAlbum> persistedAlbums = repository.findAll();
        List<SharedAlbumDto> albums = null;
        if (!persistedAlbums.isEmpty()) {
            albums = new ArrayList<>();
            for (SharedAlbum persistedAlbum : persistedAlbums) {
                albums.add(mapper.map(persistedAlbum, SharedAlbumDto.class));
            }
        }
        return albums;
    }

    /**
     * Gets the information about specific shared album.
     *
     * @param sharedAlbumId Identifier of the shared album from which we want
     * the information
     * @throws NotFoundException No shared album was found with the identifier
     * @return Shared album information
     */
    @Override
    public SharedAlbumDto getSharedAlbum(Integer sharedAlbumId) {
        Optional<SharedAlbum> optionalShared = repository
                .findById(sharedAlbumId);
        if (optionalShared.isPresent()) {
            return mapper.map(optionalShared.get(), SharedAlbumDto.class);
        } else {
            throw new NotFoundException("No shared album was found with"
                    + " the identifier: " + sharedAlbumId);
        }
    }

    /**
     * Gets the users associated to a specific album and a specific permission.
     *
     * @param albumId Album identificator
     * @param permission Permission name
     * @throws NotFoundException The permission or the album does not exist
     * @return Shared album list
     */
    @Override
    public List<SharedAlbumDto> getUsersBySharedAlbumAndPermission(
            Integer albumId, String permission) {
        List<SharedAlbumDto> sharedAlbums = null;
        try {
            EPermission ePermission = EPermission.valueOf(permission);
            albumService.getAlbum(albumId);
            if (ePermission != null) {
                Set<EPermission> permissionSet = new HashSet<>();
                permissionSet.add(ePermission);
                List<SharedAlbum> shared = repository
                        .findByAlbumIdAndPermissionIn(albumId, permissionSet);
                if (shared != null && !shared.isEmpty()) {
                    sharedAlbums = new ArrayList<>();
                    for (SharedAlbum sharedAlbum : shared) {
                        sharedAlbums.add(mapper.map(sharedAlbum,
                                SharedAlbumDto.class));
                    }
                }
            }
        } catch (RuntimeException e) {
            throw new NotFoundException(permission + " permission does not"
                    + " exist");
        }
        return sharedAlbums;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.web.dto.SharedAlbumDto;
import com.alejocastrillon.woloxchallenge.model.entity.SharedAlbum;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alejocastrillon.woloxchallenge.model.repository.SharedAlbumRepository;
import com.alejocastrillon.woloxchallenge.services.SharedAlbumService;

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
        return album != null && album.getId() != null
                && album.getTitle() != null && album.getUserId() != null;
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
        if (persistedAlbums != null && !persistedAlbums.isEmpty()) {
            albums = new ArrayList<>();
            for (SharedAlbum persistedAlbum : persistedAlbums) {
                albums.add(mapper.map(persistedAlbum, SharedAlbumDto.class));
            }
        }
        return albums;
    }

}

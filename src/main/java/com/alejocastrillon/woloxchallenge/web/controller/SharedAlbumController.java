/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.web.dto.SharedAlbumDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alejocastrillon.woloxchallenge.services.SharedAlbumService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Shared albums controller.
 *
 * @author alejandroutp
 */
@RestController
@RequestMapping("${api.base.url}/shared-albums")
@ApiOperation(value = "Shared albums controller")
public class SharedAlbumController {

    /**
     * Shared albums service instance.
     */
    @Autowired
    private SharedAlbumService service;

    /**
     * Persists the information of the shared album.
     *
     * @param album Shared album information
     * @return Shared album information persisted
     */
    @ApiOperation(value = "Persists the information of the shared album")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The shared album was persisted"
                + " successfully", response = SharedAlbumDto.class),
        @ApiResponse(code = 400, message = "An error has occurred")
    })
    @PostMapping()
    public ResponseEntity saveSharedAlbum(
            @ApiParam(value = "Shared album information")
            @RequestBody SharedAlbumDto album) {
        SharedAlbumDto saveAlbum = service.saveAlbumShared(album);
        return new ResponseEntity(saveAlbum, saveAlbum != null
                ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    /**
     * Returns in a response entity all the shared albums.
     *
     * @return Response entity with all the shared albums
     */
    @ApiOperation(value = "Returns in a response entity all the shared albums")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The shared albums were obtained"
                + " successfully", response = SharedAlbumDto.class,
                responseContainer = "List<>"),
        @ApiResponse(code = 204, message = "No content")
    })
    @GetMapping()
    public ResponseEntity getSharedAlbums() {
        List<SharedAlbumDto> albums = service.getSharedAlbums();
        return new ResponseEntity(albums, albums != null && !albums.isEmpty()
                ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }
}

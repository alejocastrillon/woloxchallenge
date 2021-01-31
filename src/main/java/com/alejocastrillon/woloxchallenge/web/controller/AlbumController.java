/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.services.AlbumService;
import com.alejocastrillon.woloxchallenge.web.dto.AlbumDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Album controller.
 *
 * @author alejandroutp
 */
@RestController
@RequestMapping("${api.base.url}/albums")
@ApiOperation(value = "Album controller")
public class AlbumController {

    /**
     * Album service instance.
     */
    @Autowired
    private AlbumService service;

    /**
     * Returns in a response entity all the albums.
     *
     * @return Response entity with all the albums
     */
    @ApiOperation(value = "Returns in a response entity all the albums")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "All the albums have been obtained",
                responseContainer = "List<>", response = AlbumDto.class)
    })
    @GetMapping()
    public ResponseEntity getAlbums() {
        return new ResponseEntity(service.getAlbums(), HttpStatus.OK);
    }

    /**
     * Returns in a response entity the albums associated to an user.
     *
     * @param userId User ID
     * @return Response entity with albums
     */
    @ApiOperation(value = "Returns in a response entity the albums associated"
            + " to an user")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The albums associated to an user"
                + " have been obtained", responseContainer = "List<>",
                response = AlbumDto.class)
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity getAlbumsByUser(@ApiParam(value = "User ID")
            @PathVariable("userId") Integer userId) {
        return new ResponseEntity(service.getAlbumsByUser(userId),
                HttpStatus.OK);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.services.PhotoService;
import com.alejocastrillon.woloxchallenge.web.dto.PhotoDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Photo rest template controller
 *
 * @author alejandroutp
 */
@RestController
@RequestMapping("${api.base.url}/photos")
@ApiOperation(value = "Photo rest template controller")
public class PhotoController {

    /**
     * Photo rest template service instance.
     */
    @Autowired
    private PhotoService service;

    /**
     * Returns in a response entity all the photos obtained in the service.
     *
     * @return Response entity with all the photos information
     */
    @ApiOperation(value = "Returns in a response entity all the photos obtained"
            + " in the service", response = PhotoDto.class,
            responseContainer = "List<>", code = 200)
    @GetMapping()
    public ResponseEntity<PhotoDto[]> getPhotos() {
        return new ResponseEntity<>(service.getPhotos(), HttpStatus.OK);
    }

    /**
     * Returns in a response entity all the photos associated to an user.
     *
     * @param userId User ID
     * @return Response entity with all the user photos.
     */
    @ApiOperation(value = "Returns in a response entity all the photos"
            + " associated to an user", response = PhotoDto.class,
            responseContainer = "List<>", code = 200)
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PhotoDto>> getPhotosByUser(
            @ApiParam(value = "User ID")
            @PathVariable("userId") Integer userId) {
        return new ResponseEntity<>(service.getPhotosByUser(userId),
                HttpStatus.OK);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.web.dto.PermissionUserSharedAlbumDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alejocastrillon.woloxchallenge.services.PermissionUserSharedAlbumService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * User permission controller associated with albums.
 *
 * @author alejandroutp
 */
@RestController
@RequestMapping("${api.base.url}/users-album")
@ApiOperation(value = "User permission controller associated with albums")
public class PermissionUserSharedAlbumController {

    /**
     * Instance of the user permission service associated with the albums.
     */
    @Autowired
    private PermissionUserSharedAlbumService service;

    /**
     * Persist the user permission on an album.
     *
     * @param permission User permission info
     * @return Response entity with the user permission info persisted
     */
    @ApiOperation(value = "Persist the user permission on an album")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "The user permission info was"
                + " persisted successfully",
                response = PermissionUserSharedAlbumDto.class),
        @ApiResponse(code = 400, message = "An error has occurred")
    })
    @PostMapping()
    public ResponseEntity savePermission(
            @ApiParam(value = "User permission info")
            @RequestBody PermissionUserSharedAlbumDto permission) {
        PermissionUserSharedAlbumDto savedPermission = service
                .savePermission(permission);
        return new ResponseEntity(savedPermission, savedPermission != null
                ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    /**
     * Returns in a response entity all the users associated to an album with an
     * specific permission.
     *
     * @param albumId Album identificador
     * @param permission Permission name
     * @return User list
     */
    @ApiOperation(value = "Returns in a response entity all the users"
            + " associated to an album with an specific permission")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The users associated with the album"
                + " were obtained with the specific permission",
                response = PermissionUserSharedAlbumDto.class,
                responseContainer = "List<>"),
        @ApiResponse(code = 204, message = "No content")
    })
    @GetMapping("/associated")
    public ResponseEntity getUsersAsociatedToAlbum(
            @ApiParam(value = "Album identificator")
            @RequestParam("albumId") Integer albumId,
            @ApiParam(value = "Permission name")
            @RequestParam("permission") String permission) {
        List<PermissionUserSharedAlbumDto> permissions = service
                .getUsersWithPermissionInAlbum(albumId, permission);
        return new ResponseEntity(permissions, permissions != null
                && !permissions.isEmpty() ? HttpStatus.OK
                : HttpStatus.NO_CONTENT);
    }

}

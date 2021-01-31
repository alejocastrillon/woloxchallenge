/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User permissions into album DTO class.
 *
 * @author alejandroutp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "User permissions into album DTO class")
public class PermissionUserSharedAlbumDto {

    /**
     * User permission identifier.
     */
    @ApiModelProperty(name = "User permission identifier")
    private Integer id;
    /**
     * Shared album identifier.
     */
    @ApiModelProperty(name = "Shared album identifier")
    private Integer sharedAlbumId;
    /**
     * User ID.
     */
    @ApiModelProperty(name = "User ID")
    private Integer userId;
    /**
     * Determines if the user can read the album content.
     */
    @ApiModelProperty(name = "Determines if the user can read the album"
            + " content")
    private boolean canRead;
    /**
     * Determines if the user can write content on the album.
     */
    @ApiModelProperty(name = "Determines if the user can write content on the"
            + " album")
    private boolean canWrite;

}

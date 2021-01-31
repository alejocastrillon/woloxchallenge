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
 * Shared album DTO class.
 *
 * @author alejandroutp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Shared Album DTO class")
public class SharedAlbumDto {

    /**
     * Album identifier.
     */
    @ApiModelProperty(name = "Album identifier")
    private Integer id;
    /**
     * User ID.
     */
    @ApiModelProperty(name = "User ID")
    private Integer userId;
    /**
     * Album title.
     */
    @ApiModelProperty(name = "Album title")
    private String title;
    /**
     * Determines if the contents of the album can be read.
     */
    @ApiModelProperty(name = "Determines if the contents of the album can be"
            + " read")
    private boolean canRead;
    /**
     * Determines if the users with access to album can write content.
     */
    @ApiModelProperty(name = "Determines if the users with access to album can"
            + " write content")
    private boolean canWrite;

}

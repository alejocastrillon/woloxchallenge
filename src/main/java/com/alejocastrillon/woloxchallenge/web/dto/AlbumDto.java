/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Album DTO class.
 *
 * @author alejandroutp
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Album DTO class")
public class AlbumDto {

    /**
     * Album identifier.
     */
    @ApiModelProperty(name = "Album identifier")
    private Integer id;
    /**
     * Identifier of the user who owns the album.
     */
    @ApiModelProperty(name = "Identifier of the user who owns the album")
    private Integer userId;
    /**
     * Album title.
     */
    @ApiModelProperty(name = "Album title")
    private String title;

}

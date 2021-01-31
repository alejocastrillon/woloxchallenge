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
 * Album DTO class.
 *
 * @author alejandroutp
 */
@Data
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
     * User ID.
     */
    @ApiModelProperty(name = "User ID")
    private Integer userId;
    /**
     * Album title.
     */
    @ApiModelProperty(name = "Album title")
    private String title;

}

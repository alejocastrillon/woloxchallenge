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
 * Photo DTO class.
 *
 * @author alejandroutp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Photo DTO class")
public class PhotoDto {

    /**
     * Photo identifier.
     */
    @ApiModelProperty(name = "Photo identifier")
    private Integer id;
    /**
     * Album identifier.
     */
    @ApiModelProperty(name = "Album identifier")
    private Integer albumId;
    /**
     * Photo title.
     */
    @ApiModelProperty(name = "Photo title")
    private String title;
    /**
     * Photo URL.
     */
    @ApiModelProperty(name = "Photo URL")
    private String url;
    /**
     * Thubnail photo URL.
     */
    @ApiModelProperty(name = "Thumbnail photo URL")
    private String thumbnailUrl;

}

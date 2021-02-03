/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.web.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Shared album DTO class.
 *
 * @author alejandroutp
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Shared Album DTO class")
public class SharedAlbumDto {

    /**
     * Identifier.
     */
    @ApiModelProperty(name = "Album identifier")
    private Integer id;
    /**
     * 
     */
    private Integer albumId;
    /**
     * User ID.
     */
    @ApiModelProperty(name = "User ID")
    private Integer userId;
    private Set<String> permission;

}

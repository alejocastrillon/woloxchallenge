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
 * Geolocation DTO class.
 *
 * @author alejandroutp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Geolocation DTO class")
public class GeoDto {

    /**
     * Latitude.
     */
    @ApiModelProperty(name = "Latitude")
    private Double lat;
    /**
     * Longitude.
     */
    @ApiModelProperty(name = "Longitude")
    private Double lng;

}

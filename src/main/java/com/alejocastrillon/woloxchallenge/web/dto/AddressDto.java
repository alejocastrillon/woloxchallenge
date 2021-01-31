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
 * Address DTO class.
 *
 * @author alejandroutp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Address DTO class")
public class AddressDto {

    /**
     * Street address.
     */
    @ApiModelProperty(name = "Street address")
    private String street;
    /**
     * Suite address.
     */
    @ApiModelProperty(name = "Suite address")
    private String suite;
    /**
     * City address.
     */
    @ApiModelProperty(name = "City address")
    private String city;
    /**
     * ZIP code address.
     */
    @ApiModelProperty(name = "ZIP code address")
    private String zipcode;
    /**
     * Latitude and longitude of the address.
     */
    @ApiModelProperty(name = "Latitude and longitude of the address")
    private GeoDto geo;

}

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
 * Address DTO class.
 *
 * @author alejandroutp
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Address DTO class")
public class AddressDto {

    /**
     * Street address of the user.
     */
    @ApiModelProperty(name = "Street address of the user")
    private String street;
    /**
     * Suite address of the user.
     */
    @ApiModelProperty(name = "Suite address of the user")
    private String suite;
    /**
     * City address of the user.
     */
    @ApiModelProperty(name = "City address of the user")
    private String city;
    /**
     * ZIP code address of the user.
     */
    @ApiModelProperty(name = "ZIP code address of the user")
    private String zipcode;
    /**
     * Latitude and longitude of the address of the user.
     */
    @ApiModelProperty(name = "Latitude and longitude of the address of the"
            + " user")
    private GeoDto geo;

}

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
 * User DTO class.
 *
 * @author alejandroutp
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "User DTO class")
public class UserDto {

    /**
     * User ID.
     */
    @ApiModelProperty(name = "User ID")
    private Integer id;
    /**
     * User name.
     */
    @ApiModelProperty(name = "User name")
    private String name;
    /**
     * User nickname.
     */
    @ApiModelProperty(name = "User nickname")
    private String username;
    /**
     * User email.
     */
    @ApiModelProperty(name = "User email")
    private String email;
    /**
     * User address information.
     */
    @ApiModelProperty(name = "User address information")
    private AddressDto address;
    /**
     * User phone number.
     */
    @ApiModelProperty(name = "User phone number")
    private String phone;
    /**
     * User website.
     */
    @ApiModelProperty(name = "User website")
    private String website;
    /**
     * User company information.
     */
    @ApiModelProperty(name = "User company information")
    private CompanyDto company;

}

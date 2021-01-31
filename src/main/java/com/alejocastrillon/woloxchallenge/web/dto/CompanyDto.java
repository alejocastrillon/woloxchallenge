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
 * Company DTO class.
 *
 * @author alejandroutp
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Company DTO class")
public class CompanyDto {

    /**
     * Company name.
     */
    @ApiModelProperty(name = "Company name")
    private String name;
    /**
     * Company catch phrase.
     */
    @ApiModelProperty(name = "Company catch phrase")
    private String catchPhrase;
    /**
     * Company bs.
     */
    @ApiModelProperty(name = "Company bs")
    private String bs;

}

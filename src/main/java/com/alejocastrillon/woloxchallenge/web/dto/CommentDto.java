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
 * Comment DTO class.
 *
 * @author alejandroutp
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Comment DTO class")
public class CommentDto {

    /**
     * Comment identifier.
     */
    @ApiModelProperty(name = "Comment identifier")
    private Integer id;
    /**
     * Post identificator associated to this comment.
     */
    @ApiModelProperty(name = "Post identificator associated to this comment")
    private Integer postId;
    /**
     * Comment name.
     */
    @ApiModelProperty(name = "Comment name")
    private String name;
    /**
     * User email associated to this comment.
     */
    @ApiModelProperty(name = "User email associated to this comment")
    private String email;
    /**
     * Comment body.
     */
    @ApiModelProperty(name = "Comment body")
    private String body;

}

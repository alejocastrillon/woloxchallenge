/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Relationship between album and user entity class.
 *
 * @author alejandroutp
 */
@Entity
@Table(name = "permission_user_shared_album")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Relationship between album and user entity class")
public class PermissionUserSharedAlbum implements Serializable {

    /**
     * Identifier of the relationship between album and user.
     */
    @ApiModelProperty(name = "Identifier of the relationship between album and"
            + " user")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Shared album information.
     */
    @ApiModelProperty(name = "Shared album information")
    @JoinColumn(name = "shared_album_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SharedAlbum sharedAlbum;
    /**
     * User ID.
     */
    @ApiModelProperty(name = "User ID")
    @Column(name = "user_id")
    private Integer userId;
    /**
     * Determines if the user can read the content of the album.
     */
    @ApiModelProperty(name = "Determines if the user can read the content of"
            + " the album")
    @Column(name = "can_read")
    private boolean canRead;
    /**
     * Determines if the user can write content to album.
     */
    @ApiModelProperty(name = "Determines if the user can write content to"
            + " album")
    @Column(name = "can_write")
    private boolean canWrite;

}

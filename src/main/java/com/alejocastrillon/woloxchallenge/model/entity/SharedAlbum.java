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
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity for album information.
 *
 * @author alejandroutp
 */
@Entity
@Table(name = "shared_album")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Entity for album information")
public class SharedAlbum implements Serializable {

    /**
     * Album identifier.
     */
    @ApiModelProperty(name = "Album identifier")
    @Id
    private Integer id;
    /**
     * User ID.
     */
    @ApiModelProperty(name = "User ID")
    @Column(name = "user_id")
    private Integer userId;
    /**
     * Album title.
     */
    @ApiModelProperty(name = "Album title")
    private String title;
    /**
     * Determines if the contents of the album can be read.
     */
    @ApiModelProperty(name = "Determines if the contents of the album can be"
            + " read")
    @Column(name = "can_read")
    private boolean canRead;
    /**
     * Determines if the users with access to album can write content.
     */
    @ApiModelProperty(name = "Determines if the users with access to album can"
            + " write content")
    @Column(name = "can_write")
    private boolean canWrite;

}

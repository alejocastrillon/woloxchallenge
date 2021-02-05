/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity for shared album information.
 *
 * @author alejandroutp
 */
@Entity
@Table(name = "shared_album")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "Entity for shared album information")
public class SharedAlbum implements Serializable {

    /**
     * Identifier of the relationship between album and an user.
     */
    @ApiModelProperty(name = "Identifier of the relationship between album and"
            + " an user")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * Identifier of the album being shared.
     */
    @ApiModelProperty(name = "Identifier of the album being shared")
    @Column(name = "album_id")
    private Integer albumId;
    /**
     * Identifier of the user who is having access to the abum.
     */
    @ApiModelProperty(name = "Identifier of the user who is having access to"
            + " the album")
    @Column(name = "user_id")
    private Integer userId;
    /**
     * Set of permission that the user have into album.
     */
    @ApiModelProperty(name = "Set of permission that the user have into album")
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<EPermission> permission = new HashSet<>();

}

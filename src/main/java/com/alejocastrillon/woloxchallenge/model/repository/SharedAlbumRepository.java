/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.model.repository;

import com.alejocastrillon.woloxchallenge.model.entity.EPermission;
import com.alejocastrillon.woloxchallenge.model.entity.SharedAlbum;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Shared album repository.
 *
 * @author alejandroutp
 */
@Repository
public interface SharedAlbumRepository
        extends JpaRepository<SharedAlbum, Integer> {

    /**
     * Gets the list of shared albums that have an album identificator and a
     * permission name on specific.
     *
     * @param albumId Album identificator to search
     * @param permission Permission name to search
     * @return Shared album list
     */
    List<SharedAlbum> findByAlbumIdAndPermissionIn(Integer albumId,
            Set<EPermission> permission);
}

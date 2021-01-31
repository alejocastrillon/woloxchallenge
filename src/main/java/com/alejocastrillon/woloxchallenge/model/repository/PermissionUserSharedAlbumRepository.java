/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alejocastrillon.woloxchallenge.model.entity.PermissionUserSharedAlbum;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandroutp
 */
@Repository
public interface PermissionUserSharedAlbumRepository
        extends JpaRepository<PermissionUserSharedAlbum, Integer>{
    
    List<PermissionUserSharedAlbum> findBySharedAlbum_IdAndCanReadIsTrue(Integer albumId);
    
    List<PermissionUserSharedAlbum> findBySharedAlbum_IdAndCanWriteIsTrue(Integer albumId);
}

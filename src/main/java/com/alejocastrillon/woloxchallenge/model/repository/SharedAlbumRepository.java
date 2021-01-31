/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.model.repository;

import com.alejocastrillon.woloxchallenge.model.entity.SharedAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alejandroutp
 */
@Repository
public interface SharedAlbumRepository extends JpaRepository<SharedAlbum, Integer>{
    
}

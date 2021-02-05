/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services;

import com.alejocastrillon.woloxchallenge.web.dto.CommentDto;

/**
 * Comment service interface.
 *
 * @author alejandroutp
 */
public interface CommentService {

    /**
     * Gets all the comments.
     *
     * @return List of comments
     */
    CommentDto[] getAllComents();

    /**
     * Gets all the comments filtered by user email field.
     *
     * @param filter Filter param
     * @return List of comment
     */
    CommentDto[] getCommentsFilteredByEmail(String filter);

    /**
     * Gets all the comments filtered by name field.
     *
     * @param filter Filter param
     * @return List of comment
     */
    CommentDto[] getCommentsFilteredByName(String filter);

}

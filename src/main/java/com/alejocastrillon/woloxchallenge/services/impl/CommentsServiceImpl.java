/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.services.CommentService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
import com.alejocastrillon.woloxchallenge.web.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Comments service implementation.
 *
 * @author alejandroutp
 */
@Service
public class CommentsServiceImpl implements CommentService {

    /**
     * Rest template instance.
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * External Rest service base url.
     */
    @Value("${external.base.url}")
    private String baseUrl;

    /**
     * Not found exception message.
     */
    private static final String NOT_FOUND_EXCEPTION_MESSAGE = "No comments were found under by: ";

    /**
     * Gets all the comments.
     *
     * @return List of comments
     */
    @Override
    public CommentDto[] getAllComents() {
        return restTemplate.getForObject(baseUrl + "/comments",
                CommentDto[].class);
    }

    /**
     * Gets all the comments filtered by user email field.
     *
     * @param filter Filter param
     * @throws NotFoundException No comments were found under this parameter
     * @return List of comment
     */
    @Override
    public CommentDto[] getCommentsFilteredByEmail(String filter) {
        try {
            return restTemplate.getForObject(
                    baseUrl + "/comments?email=" + filter, CommentDto[].class);
        } catch (RuntimeException e) {
            throw new NotFoundException(NOT_FOUND_EXCEPTION_MESSAGE + filter);
        }
    }

    /**
     * Gets all the comments filtered by name field.
     *
     * @param filter Filter param
     * @throws NotFoundException No comments were found under this parameter
     * @return List of comment
     */
    @Override
    public CommentDto[] getCommentsFilteredByName(String filter) {
        try {
            return restTemplate.getForObject(baseUrl + "/comments?name=" + filter, CommentDto[].class);
        } catch (Exception e) {
            throw new NotFoundException(NOT_FOUND_EXCEPTION_MESSAGE + filter);
        }
    }

}

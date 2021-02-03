/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.services.CommentService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
import com.alejocastrillon.woloxchallenge.web.dto.CommentDto;
import java.util.Arrays;
import java.util.List;
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
     * Base url for external Rest service.
     */
    @Value("${external.base.url}")
    private String baseUrl;

    /**
     * Gets all the comments.
     *
     * @return List of comments
     */
    @Override
    public List<CommentDto> getAllComents() {
        return Arrays.asList(restTemplate.getForObject(baseUrl + "/comments",
                CommentDto[].class));
    }

    /**
     * Gets all the comments filtered by user email field.
     *
     * @param filter Filter param
     * @throws NotFoundException No comments were found under this parameter
     * @return List of comment
     */
    @Override
    public List<CommentDto> getCommentsFilteredByEmail(String filter) {
        try {
            return Arrays.asList(restTemplate.getForObject(
                    baseUrl + "/comments?email=" + filter, CommentDto[].class));
        } catch (RuntimeException e) {
            throw new NotFoundException("No comments were found under"
                    + " this parameter");
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
    public List<CommentDto> getCommentsFilteredByName(String filter) {
        try {
            return Arrays.asList(restTemplate.getForObject(
                    baseUrl + "/comments?name=" + filter, CommentDto[].class));
        } catch (Exception e) {
            throw new NotFoundException("No comments were found under"
                    + " this parameter");
        }
    }

}

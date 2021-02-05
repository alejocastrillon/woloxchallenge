/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.services.CommentService;
import com.alejocastrillon.woloxchallenge.web.dto.CommentDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Comments controller.
 *
 * @author alejandroutp
 */
@RestController
@RequestMapping("${api.base.url}/comments")
@ApiOperation(value = "Comments controller")
public class CommentController {

    /**
     * Comment service instance.
     */
    @Autowired
    private CommentService service;

    /**
     * Returns in a response entity all the comments.
     *
     * @return Response entity with all the comments
     */
    @ApiOperation(value = "Returns in a response entity all the comments")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "All the comments have been"
                + " obtained", responseContainer = "List<>",
                response = CommentDto.class),
        @ApiResponse(code = 204, message = "No comments")
    })
    @GetMapping()
    public ResponseEntity<CommentDto[]> getAllComments() {
        CommentDto[] comments = service.getAllComents();
        return new ResponseEntity<>(comments, comments != null
                && comments.length > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    /**
     * Returns in a response entity the commments associated to a name.
     *
     * @param param Filter param
     * @return Response entity with the comments
     */
    @ApiOperation(value = "Returns in a response entity the commments"
            + " associated to a name")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The comments have been obtained",
                responseContainer = "List<>", response = CommentDto.class),
        @ApiResponse(code = 204, message = "No content")
    })
    @GetMapping("/name")
    public ResponseEntity<CommentDto[]> getCommentsByName(
            @ApiParam(value = "Filter param")
            @RequestParam("param") String param) {
        CommentDto[] comments = service.getCommentsFilteredByName(param);
        return new ResponseEntity<>(comments, comments != null
                && comments.length > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

    /**
     * Returns in a response entity the commments associated to an email.
     *
     * @param param Filter param
     * @return Response entity with the comments
     */
    @ApiOperation(value = "Returns in a response entity the commments"
            + " associated to an email")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "The comments have been obtained",
                responseContainer = "List<>", response = CommentDto.class),
        @ApiResponse(code = 204, message = "No content")
    })
    @GetMapping("/email")
    public ResponseEntity<CommentDto[]> getCommentsByEmail(
            @ApiParam(value = "Filter param")
            @RequestParam("param") String param) {
        CommentDto[] comments = service.getCommentsFilteredByEmail(param);
        return new ResponseEntity<>(comments, comments != null
                && comments.length > 0 ? HttpStatus.OK : HttpStatus.NO_CONTENT);
    }

}

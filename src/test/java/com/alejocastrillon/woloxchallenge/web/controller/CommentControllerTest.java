package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.services.CommentService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
import com.alejocastrillon.woloxchallenge.web.dto.CommentDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CommentControllerTest {

    @Mock
    private CommentService service;

    @InjectMocks
    private CommentController commentController;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAllComments() {
        CommentDto comment = new CommentDto();
        comment.setId(1);
        comment.setName("Alejo");
        comment.setEmail("alejandro@utp.edu.co");
        comment.setBody("Hola");
        comment.setPostId(1);
        CommentDto[] comments = { comment };
        Mockito.when(service.getAllComents()).thenReturn(comments);
        ResponseEntity<CommentDto[]> result = commentController.getAllComments();
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertEquals(comment.getId(), result.getBody()[0].getId());
    }

    @Test
    public void getCommentsByName() {
        CommentDto comment = new CommentDto();
        comment.setId(1);
        comment.setName("Alejo");
        comment.setEmail("alejandro@utp.edu.co");
        comment.setBody("Hola");
        comment.setPostId(1);
        CommentDto[] comments = { comment };
        Mockito.when(service.getCommentsFilteredByName(comment.getName())).thenReturn(comments);
        ResponseEntity<CommentDto[]> result = commentController.getCommentsByName(comment.getName());
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertEquals(comment.getId(), result.getBody()[0].getId());
    }

    @Test(expected = NotFoundException.class)
    public void getCommentsByNameNotFound() {
        Mockito.when(service.getCommentsFilteredByName("Alejandro")).thenThrow(NotFoundException.class);
        commentController.getCommentsByName("Alejandro");
    }

    @Test
    public void getCommentsByEmail() {
        CommentDto comment = new CommentDto();
        comment.setId(1);
        comment.setName("Alejo");
        comment.setEmail("alejandro@utp.edu.co");
        comment.setBody("Hola");
        comment.setPostId(1);
        CommentDto[] comments = { comment };
        Mockito.when(service.getCommentsFilteredByEmail(comment.getEmail())).thenReturn(comments);
        ResponseEntity<CommentDto[]> result = commentController.getCommentsByEmail(comment.getEmail());
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertEquals(comment.getId(), result.getBody()[0].getId());
    }

    @Test(expected = NotFoundException.class)
    public void getCommentsByEmailNotFound() {
        Mockito.when(service.getCommentsFilteredByEmail("alejandro.castrillon@utp.edu.co"))
                .thenThrow(NotFoundException.class);
        commentController.getCommentsByEmail("alejandro.castrillon@utp.edu.co");
    }

}
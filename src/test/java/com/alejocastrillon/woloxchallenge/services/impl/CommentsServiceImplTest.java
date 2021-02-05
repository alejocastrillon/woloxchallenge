package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.web.dto.CommentDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CommentsServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CommentsServiceImpl service;

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    @Test
    public void getAllComents() {
        ReflectionTestUtils.setField(service, "baseUrl", baseUrl);
        CommentDto comment = new CommentDto();
        comment.setId(1);
        comment.setBody("Hola");
        comment.setEmail("prueba@gmail.com");
        comment.setName("Comentario");
        comment.setPostId(1);
        CommentDto[] comms = { comment };
        Mockito.when(restTemplate.getForObject(baseUrl + "/comments", CommentDto[].class))
                .thenReturn(comms);
        CommentDto[] comments = service.getAllComents();
        Assert.assertNotNull(comments);
        Assert.assertTrue(comments.length > 0);
    }

    @Test
    public void getCommentsFilteredByEmail() {
        CommentDto comment = new CommentDto();
        comment.setId(1);
        comment.setBody("Hola");
        comment.setEmail("prueba@gmail.com");
        comment.setName("Comentario");
        comment.setPostId(1);
        CommentDto[] comms = { comment };
        ReflectionTestUtils.setField(service, "baseUrl", baseUrl);
        Mockito.when(restTemplate.getForObject(baseUrl + "/comments?email=" + comment.getEmail(),
                CommentDto[].class)).thenReturn(comms);
        CommentDto[] comments = service.getCommentsFilteredByEmail(comment.getEmail());
        Assert.assertNotNull(comments);
        Assert.assertEquals(comment.getEmail(), comments[0].getEmail());
    }

    @Test
    public void getCommentsFilteredByName() {
        CommentDto comment = new CommentDto();
        comment.setId(1);
        comment.setBody("Hola");
        comment.setEmail("prueba@gmail.com");
        comment.setName("Comentario");
        comment.setPostId(1);
        CommentDto[] comms = { comment };
        ReflectionTestUtils.setField(service, "baseUrl", baseUrl);
        Mockito.when(restTemplate.getForObject(baseUrl + "/comments?name=" + comment.getName(),
                CommentDto[].class)).thenReturn(comms);
        CommentDto[] comments = service.getCommentsFilteredByName(comment.getName());
        Assert.assertNotNull(comments);
        Assert.assertEquals(comment.getName(), comments[0].getName());
    }
}
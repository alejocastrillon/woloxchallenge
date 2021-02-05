package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.services.AlbumService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
import com.alejocastrillon.woloxchallenge.web.dto.AlbumDto;
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
public class AlbumControllerTest {

    @Mock
    private AlbumService service;

    @InjectMocks
    private AlbumController albumController;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAlbums() {
        AlbumDto album = new AlbumDto();
        album.setId(1);
        album.setUserId(1);
        album.setTitle("Hola");
        AlbumDto[] albums = { album };
        Mockito.when(service.getAlbums()).thenReturn(albums);
        ResponseEntity<AlbumDto[]> result = albumController.getAlbums();
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertEquals(album.getId(), result.getBody()[0].getId());
    }

    @Test
    public void getAlbumsByUser() {
        AlbumDto album = new AlbumDto();
        album.setId(1);
        album.setUserId(1);
        album.setTitle("Hola");
        AlbumDto[] albums = { album };
        Mockito.when(service.getAlbumsByUser(album.getUserId())).thenReturn(albums);
        ResponseEntity<AlbumDto[]> result = albumController.getAlbumsByUser(album.getUserId());
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertEquals(album.getUserId(), result.getBody()[0].getUserId());
    }

    @Test(expected = NotFoundException.class)
    public void getAlbumsByUserNotFound() {
        Mockito.when(service.getAlbumsByUser(Mockito.any(Integer.class))).thenThrow(NotFoundException.class);
        albumController.getAlbumsByUser(Mockito.any(Integer.class));
    }
}
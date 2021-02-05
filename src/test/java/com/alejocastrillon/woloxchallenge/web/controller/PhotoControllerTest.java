package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.services.PhotoService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
import com.alejocastrillon.woloxchallenge.web.dto.PhotoDto;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class PhotoControllerTest {

    @Mock
    private PhotoService service;

    @InjectMocks
    private PhotoController photoController;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getPhotos() {
        PhotoDto photo = new PhotoDto();
        photo.setId(1);
        photo.setTitle("Photo");
        photo.setAlbumId(1);
        photo.setUrl("http://www.google.com");
        PhotoDto[] photos = { photo };
        Mockito.when(service.getPhotos()).thenReturn(photos);
        ResponseEntity<PhotoDto[]> result = photoController.getPhotos();
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertEquals(photo.getId(), result.getBody()[0].getId());
    }

    @Test
    public void getPhotosByUser() {
        PhotoDto photo = new PhotoDto();
        photo.setId(1);
        photo.setTitle("Photo");
        photo.setAlbumId(1);
        photo.setUrl("http://www.google.com");
        List<PhotoDto> photos = new ArrayList<>();
        photos.add(photo);
        Mockito.when(service.getPhotosByUser(1)).thenReturn(photos);
        ResponseEntity<List<PhotoDto>> result = photoController.getPhotosByUser(1);
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertEquals(photo.getId(), result.getBody().get(0).getId());
    }

    @Test(expected = NotFoundException.class)
    public void getPhotosByUserNotFound() {
        Mockito.when(service.getPhotosByUser(1)).thenThrow(NotFoundException.class);
        photoController.getPhotosByUser(1);
    }

}
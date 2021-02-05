package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.services.AlbumService;
import com.alejocastrillon.woloxchallenge.services.UserService;
import com.alejocastrillon.woloxchallenge.web.dto.AlbumDto;
import com.alejocastrillon.woloxchallenge.web.dto.PhotoDto;
import com.alejocastrillon.woloxchallenge.web.dto.UserDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class PhotoServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private AlbumService albumService;

    @Mock
    private UserService userService;

    @InjectMocks
    private PhotoServiceImpl service;

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getPhotos() {
        ReflectionTestUtils.setField(service, "baseUrl", baseUrl);
        PhotoDto photo = new PhotoDto();
        photo.setId(1);
        photo.setAlbumId(1);
        photo.setUrl("http://www.google.com");
        photo.setThumbnailUrl("http://www.google.com");
        photo.setTitle("Foto");
        PhotoDto[] photos = { photo };
        Mockito.when(restTemplate.getForObject(baseUrl + "/photos", PhotoDto[].class)).thenReturn(photos);
        PhotoDto[] photosService = service.getPhotos();
        Assert.assertNotNull(photosService);
        Assert.assertTrue(photosService.length > 0);
    }

    @Test
    public void getPhotosByUser() {
        ReflectionTestUtils.setField(service, "baseUrl", baseUrl);
        UserDto user = new UserDto();
        user.setId(1);
        AlbumDto album = new AlbumDto();
        album.setId(1);
        album.setUserId(1);
        album.setTitle("Album");
        AlbumDto[] albs = { album };
        PhotoDto photo = new PhotoDto();
        photo.setId(1);
        photo.setAlbumId(1);
        photo.setUrl("http://www.google.com");
        photo.setThumbnailUrl("http://www.google.com");
        photo.setTitle("Foto");
        PhotoDto[] photos = { photo };
        Mockito.when(userService.getUser(user.getId())).thenReturn(user);
        Mockito.when(albumService.getAlbumsByUser(user.getId())).thenReturn(albs);
        for (AlbumDto alb : albs) {
            Mockito.when(restTemplate.getForObject(baseUrl + "/photos?albumId=" + alb.getId(), PhotoDto[].class))
                    .thenReturn(photos);
        }
        List<PhotoDto> photosByUser = service.getPhotosByUser(user.getId());
        Assert.assertNotNull(photosByUser);
        Assert.assertTrue(!photosByUser.isEmpty());
    }

}
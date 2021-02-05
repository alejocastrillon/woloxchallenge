package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.services.UserService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
import com.alejocastrillon.woloxchallenge.web.dto.AlbumDto;
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

@RunWith(SpringRunner.class)
public class AlbumServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private UserService userService;

    @InjectMocks
    private AlbumServiceImpl service;

    private final String baseUrl = "https://jsonplaceholder.typicode.com";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getAlbums() {
        ReflectionTestUtils.setField(service, "baseUrl", baseUrl);
        AlbumDto album = new AlbumDto();
        album.setId(1);
        album.setUserId(1);
        album.setTitle("Primer");
        AlbumDto[] albs = { album };
        Mockito.doReturn(albs).when(restTemplate).getForObject(
                baseUrl + "/albums", AlbumDto[].class);
        AlbumDto[] albums = service.getAlbums();
        Assert.assertNotNull(albums);
        Assert.assertTrue(albums.length > 0);
    }



    @Test
    public void getAlbumsByUser() {
        UserDto user = new UserDto();
        user.setId(1);
        Mockito.when(userService.getUser(user.getId())).thenReturn(user);
        ReflectionTestUtils.setField(service, "baseUrl", baseUrl);
        AlbumDto album = new AlbumDto();
        album.setId(1);
        album.setUserId(1);
        album.setTitle("Primer");
        AlbumDto[] albs = { album };
        Mockito.when(restTemplate.getForObject(
                baseUrl + "/albums?userId=" + user.getId(), AlbumDto[].class))
                .thenReturn(albs);
        AlbumDto[] albums = service.getAlbumsByUser(user.getId());
        Assert.assertNotNull(albums);
    }

    @Test(expected = NotFoundException.class)
    public void getAlbumsByUserNotFoundException() {
        UserDto user = new UserDto();
        user.setId(1);
        Mockito.when(userService.getUser(user.getId())).thenThrow(NotFoundException.class);
        AlbumDto[] albums = service.getAlbumsByUser(user.getId());
    }

    @Test
    public void getAlbum() {
        AlbumDto album = new AlbumDto();
        album.setId(1);
        album.setUserId(1);
        album.setTitle("Primer");
        ReflectionTestUtils.setField(service, "baseUrl", baseUrl);
        Mockito.when(restTemplate.getForObject(
                baseUrl + "/albums/" + album.getId(), AlbumDto.class))
                .thenReturn(album);
        AlbumDto albumTest = service.getAlbum(album.getId());
        Assert.assertNotNull(albumTest);
    }

}
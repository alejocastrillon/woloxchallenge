package com.alejocastrillon.woloxchallenge.web.controller;

import com.alejocastrillon.woloxchallenge.model.entity.EPermission;
import com.alejocastrillon.woloxchallenge.services.SharedAlbumService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
import com.alejocastrillon.woloxchallenge.web.dto.SharedAlbumDto;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class SharedAlbumControllerTest {

    @Mock
    private SharedAlbumService service;

    @InjectMocks
    private SharedAlbumController controller;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void saveSharedAlbum() {
        Set<String> permissions = new HashSet<>();
        permissions.add("WRITE");
        SharedAlbumDto shared = new SharedAlbumDto();
        shared.setId(1);
        shared.setAlbumId(1);
        shared.setUserId(1);
        shared.setPermission(permissions);
        Mockito.when(service.saveAlbumShared(shared)).thenReturn(shared);
        ResponseEntity<SharedAlbumDto> result = controller.saveSharedAlbum(shared);
        Assert.assertEquals(HttpStatus.CREATED, result.getStatusCode());
        Assert.assertEquals(shared.getId(), result.getBody().getId());
    }

    @Test(expected = NotFoundException.class)
    public void saveSharedAlbumNotFoundPermissions() {
        Set<String> permissions = new HashSet<>();
        permissions.add("MODIFY");
        SharedAlbumDto shared = new SharedAlbumDto();
        shared.setId(1);
        shared.setAlbumId(1);
        shared.setUserId(1);
        shared.setPermission(permissions);
        Mockito.when(service.saveAlbumShared(shared)).thenThrow(NotFoundException.class);
        controller.saveSharedAlbum(shared);
    }

    @Test
    public void getSharedAlbums() {
        Set<String> permissions = new HashSet<>();
        permissions.add("WRITE");
        SharedAlbumDto sharedAlbum = new SharedAlbumDto();
        sharedAlbum.setId(1);
        sharedAlbum.setAlbumId(1);
        sharedAlbum.setUserId(1);
        sharedAlbum.setPermission(permissions);
        List<SharedAlbumDto> sharedAlbums = new ArrayList<>();
        sharedAlbums.add(sharedAlbum);
        Mockito.when(service.getSharedAlbums()).thenReturn(sharedAlbums);
        ResponseEntity<List<SharedAlbumDto>> result = controller.getSharedAlbums();
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertEquals(sharedAlbum.getId(), result.getBody().get(0).getId());
    }

    @Test
    public void getUserByAlbumAndPermission() {
        Set<String> permissions = new HashSet<>();
        permissions.add("WRITE");
        SharedAlbumDto sharedAlbum = new SharedAlbumDto();
        sharedAlbum.setId(1);
        sharedAlbum.setAlbumId(1);
        sharedAlbum.setUserId(1);
        sharedAlbum.setPermission(permissions);
        List<SharedAlbumDto> sharedAlbums = new ArrayList<>();
        sharedAlbums.add(sharedAlbum);
        Mockito.when(service.getUsersBySharedAlbumAndPermission(sharedAlbum.getAlbumId(), "WRITE"))
                .thenReturn(sharedAlbums);
        ResponseEntity<List<SharedAlbumDto>> result = controller.getUserByAlbumAndPermission(sharedAlbum
                .getAlbumId(), "WRITE");
        Assert.assertEquals(HttpStatus.OK, result.getStatusCode());
        Assert.assertEquals(sharedAlbum.getAlbumId(), result.getBody().get(0).getAlbumId());
        Assert.assertTrue(result.getBody().get(0).getPermission().contains("WRITE"));
    }
}
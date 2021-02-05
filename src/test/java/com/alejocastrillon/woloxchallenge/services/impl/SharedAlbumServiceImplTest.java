package com.alejocastrillon.woloxchallenge.services.impl;

import com.alejocastrillon.woloxchallenge.model.entity.EPermission;
import com.alejocastrillon.woloxchallenge.model.entity.SharedAlbum;
import com.alejocastrillon.woloxchallenge.model.repository.SharedAlbumRepository;
import com.alejocastrillon.woloxchallenge.services.AlbumService;
import com.alejocastrillon.woloxchallenge.services.UserService;
import com.alejocastrillon.woloxchallenge.services.exception.httpstatus.NotFoundException;
import com.alejocastrillon.woloxchallenge.web.dto.AlbumDto;
import com.alejocastrillon.woloxchallenge.web.dto.SharedAlbumDto;
import com.alejocastrillon.woloxchallenge.web.dto.UserDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class SharedAlbumServiceImplTest {

    @Mock
    private SharedAlbumRepository repository;

    @Mock
    private AlbumService albumService;

    @Mock
    private UserService userService;

    @InjectMocks
    private SharedAlbumServiceImpl service;

    private final ModelMapper mapper = new ModelMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void saveAlbumShared() {
        AlbumDto album = new AlbumDto();
        album.setId(1);
        album.setUserId(1);
        album.setTitle("Album");
        UserDto user = new UserDto();
        user.setId(1);
        SharedAlbumDto sharedAlbum = new SharedAlbumDto();
        sharedAlbum.setId(1);
        sharedAlbum.setUserId(user.getId());
        sharedAlbum.setAlbumId(album.getId());
        Set<String> permissions = new HashSet<>();
        permissions.add("WRITE");
        sharedAlbum.setPermission(permissions);
        Set<EPermission> ePermissions = new HashSet<>();
        ePermissions.add(EPermission.WRITE);
        SharedAlbum saveShared = new SharedAlbum();
        saveShared.setId(1);
        saveShared.setAlbumId(1);
        saveShared.setUserId(1);
        saveShared.setPermission(ePermissions);
        Mockito.when(albumService.getAlbum(sharedAlbum.getAlbumId())).thenReturn(album);
        Mockito.when(userService.getUser(sharedAlbum.getUserId())).thenReturn(user);
        Mockito.when(repository.save(Mockito.any(SharedAlbum.class))).thenReturn(saveShared);
        SharedAlbumDto savedShared = service.saveAlbumShared(sharedAlbum);
        Assert.assertNotNull(savedShared);
        Assert.assertEquals(sharedAlbum.getId(), savedShared.getId());
    }

    @Test(expected = NotFoundException.class)
    public void saveAlbumSharedAlbumNotFound() {
        UserDto user = new UserDto();
        user.setId(1);
        SharedAlbumDto sharedAlbum = new SharedAlbumDto();
        sharedAlbum.setId(1);
        sharedAlbum.setUserId(user.getId());
        sharedAlbum.setAlbumId(1);
        Set<String> permissions = new HashSet<>();
        permissions.add("WRITE");
        sharedAlbum.setPermission(permissions);
        Mockito.when(albumService.getAlbum(sharedAlbum.getAlbumId())).thenThrow(NotFoundException.class);
        service.saveAlbumShared(sharedAlbum);
    }

    @Test(expected = NotFoundException.class)
    public void shaveAlbumSharedAndUserNotFound() {
        AlbumDto album = new AlbumDto();
        album.setId(1);
        album.setUserId(1);
        album.setTitle("Album");
        SharedAlbumDto sharedAlbum = new SharedAlbumDto();
        sharedAlbum.setId(1);
        sharedAlbum.setUserId(1);
        sharedAlbum.setAlbumId(album.getId());
        Set<String> permissions = new HashSet<>();
        permissions.add("WRITE");
        sharedAlbum.setPermission(permissions);
        Mockito.when(albumService.getAlbum(sharedAlbum.getAlbumId())).thenReturn(album);
        Mockito.when(userService.getUser(sharedAlbum.getUserId())).thenThrow(NotFoundException.class);
        service.saveAlbumShared(sharedAlbum);
    }

    @Test(expected = NotFoundException.class)
    public void saveAlbumSharedAndPermissionNotFound() {
        AlbumDto album = new AlbumDto();
        album.setId(1);
        album.setUserId(1);
        album.setTitle("Album");
        UserDto user = new UserDto();
        user.setId(1);
        SharedAlbumDto sharedAlbum = new SharedAlbumDto();
        sharedAlbum.setId(1);
        sharedAlbum.setUserId(user.getId());
        sharedAlbum.setAlbumId(album.getId());
        Set<String> permissions = new HashSet<>();
        permissions.add("MODIFY");
        sharedAlbum.setPermission(permissions);
        Mockito.when(albumService.getAlbum(sharedAlbum.getAlbumId())).thenReturn(album);
        Mockito.when(userService.getUser(sharedAlbum.getUserId())).thenReturn(user);
        service.saveAlbumShared(sharedAlbum);
    }
    @Test
    public void getSharedAlbums() {
        Set<EPermission> ePermissions = new HashSet<>();
        ePermissions.add(EPermission.WRITE);
        List<SharedAlbum> shared = new ArrayList<>();
        shared.add(new SharedAlbum(1, 1, 1, ePermissions));
        Mockito.when(repository.findAll()).thenReturn(shared);
        List<SharedAlbumDto> sharedAlbums = service.getSharedAlbums();
        Assert.assertNotNull(sharedAlbums);
    }

    @Test
    public void getSharedAlbum() {
        SharedAlbum sharedAlbum = new SharedAlbum();
        sharedAlbum.setId(1);
        sharedAlbum.setAlbumId(1);
        sharedAlbum.setUserId(1);
        Mockito.when(repository.findById(sharedAlbum.getId())).thenReturn(Optional.of(sharedAlbum));
        SharedAlbumDto shared = service.getSharedAlbum(sharedAlbum.getId());
        Assert.assertNotNull(shared);
        Assert.assertEquals(sharedAlbum.getId(), shared.getId());
    }

    @Test(expected = NotFoundException.class)
    public void getSharedAlbumNotFound() {
        Mockito.when(repository.findById(Mockito.any(Integer.class))).thenReturn(Optional.empty());
        service.getSharedAlbum(Mockito.any(Integer.class));
    }

    @Test
    public void getUsersBySharedAlbumAndPermission() {
        Set<EPermission> ePermissions = new HashSet<>();
        ePermissions.add(EPermission.WRITE);
        SharedAlbum sharedAlbum = new SharedAlbum();
        sharedAlbum.setAlbumId(1);
        sharedAlbum.setPermission(ePermissions);
        List<SharedAlbum> sharedAlbums = new ArrayList<>();
        sharedAlbums.add(sharedAlbum);
        Mockito.when(repository.findByAlbumIdAndPermissionIn(sharedAlbum.getAlbumId(), ePermissions))
                .thenReturn(sharedAlbums);
        List<SharedAlbumDto> sharedAlbumsDto = service
                .getUsersBySharedAlbumAndPermission(sharedAlbum.getAlbumId(), "WRITE");
        Assert.assertNotNull(sharedAlbumsDto);
        Assert.assertEquals(sharedAlbum.getAlbumId(), sharedAlbumsDto.get(0).getAlbumId());
        Assert.assertTrue(sharedAlbumsDto.get(0).getPermission().contains("WRITE"));
    }
}
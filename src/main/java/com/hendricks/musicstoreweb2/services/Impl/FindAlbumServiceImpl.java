/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.Album;
import com.hendricks.musicstoreweb2.repository.AlbumRepository;
import com.hendricks.musicstoreweb2.services.FindAlbumService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class FindAlbumServiceImpl implements FindAlbumService{
@Autowired
private AlbumRepository repo;
private Long id;

    @Override
    public String findAlbum(String Album) {
        Album a = new Album.Builder("Intervensie")
                .build();
        Album a1 = new Album.Builder("Bad Religion")
                .build();
        Album a2 = new Album.Builder("The Suffer & The Witness")
                .build();     
        
        List<Album> albums = new ArrayList<>();
        
        repo.save(a);
        id = a.getId();
        albums.add(repo.findOne(id));
        repo.save(a1);
        id = a1.getId();
        albums.add(repo.findOne(id));
        repo.save(a2);
        id = a2.getId();
        albums.add(repo.findOne(id));
        
        for(int x = 0; x <= albums.size(); x++){
            if(albums.get(x).getName().equals(Album)){
                return albums.get(x).getName();
            }
        }
        return null;
    }
    
}

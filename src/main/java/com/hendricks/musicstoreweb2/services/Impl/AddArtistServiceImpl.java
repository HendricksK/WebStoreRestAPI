/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.Album;
import com.hendricks.musicstoreweb2.domain.Artist;
import com.hendricks.musicstoreweb2.domain.Genre;
import com.hendricks.musicstoreweb2.repository.ArtistRepository;
import com.hendricks.musicstoreweb2.services.AddArtistService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class AddArtistServiceImpl implements AddArtistService{
@Autowired
private ArtistRepository repo;
private Long id;

    @Override
    public boolean addMusic(String name) {
        List <Album> albums = new ArrayList<>();
        Album a = new Album.Builder("Downtown Battle Mountain II")
                .build();
        
        albums.add(a);
        
        Genre g = new Genre.Builder("Post Hardcore")
                .build();
        
        Artist artist = new Artist.Builder(name)
                .setName("Will Swan, Tilian")
                .setGenre(g)
               .setAlbums(albums)
                .build();
        
        Artist a2 = new Artist.Builder(name)
                .build();
        
        repo.save(artist);
        id = artist.getId();
        
        Artist artist2 = repo.findOne(id);
        
        if(artist.equals(artist2))
            return true;
        else return false;
    }
    
}

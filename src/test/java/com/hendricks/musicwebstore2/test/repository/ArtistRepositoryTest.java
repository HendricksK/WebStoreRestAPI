/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.repository;

import com.hendricks.musicstoreweb2.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb2.domain.Album;
import com.hendricks.musicstoreweb2.domain.Artist;
import com.hendricks.musicstoreweb2.domain.Genre;
import com.hendricks.musicstoreweb2.repository.ArtistRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author kurvin
 */
public class ArtistRepositoryTest {
    
    private static Long id;
    public static ApplicationContext ctx;
    
    private static ArtistRepository repo;
    
    public ArtistRepositoryTest() {
    }
                
    @Test
    public static void createArtist(){
        repo = ctx.getBean(ArtistRepository.class);
        
        List <Album> albums = new ArrayList<>();
        Album a = new Album.Builder("Downtown Battle Mountain II")
                .build();
        
        albums.add(a);
        
        Genre g = new Genre.Builder("Post Hardcore")
                .build();
        
        Artist artist = new Artist.Builder("Dance Gavin Dance")
                .setName("Will Swan, Tilian")
                .setGenre(g)
                .setAlbums(albums)
                .build();
        
        repo.save(artist);
        id = artist.getId();
        
        Assert.assertNotNull(id);
                
    }
    
    @Test(dependsOnMethods = "createArtist")
    public void readArtist(){
        repo = ctx.getBean(ArtistRepository.class);
        Artist artist = repo.findOne(id);
        Assert.assertEquals(artist.getAlias(), "Dance Gavin Dance");
    }
    
    @Test(dependsOnMethods = "createArtist")
    private void updateArtist(){
        repo = ctx.getBean(ArtistRepository.class);
        
        Artist artist = repo.findOne(id);
        Artist update = new Artist.Builder(artist.getAlias())
                .Artist(artist)
                .setName("Will Swan, Mike Geiss")
                .build();
        
        repo.save(update);
    }
    
    @Test(dependsOnMethods = "updateArtist")
    private void deleteArtist(){
        repo = ctx.getBean(ArtistRepository.class);
        repo.delete(id);
        Artist artist = repo.findOne(id);
        Assert.assertNull(artist);
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
         ctx = new AnnotationConfigApplicationContext(ConnectionConfig.class);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}

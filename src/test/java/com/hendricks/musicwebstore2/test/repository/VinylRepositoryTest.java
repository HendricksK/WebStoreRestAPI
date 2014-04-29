/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.repository;


import com.hendricks.musicstoreweb2.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb2.domain.Song;
import com.hendricks.musicstoreweb2.domain.Vinyl;
import com.hendricks.musicstoreweb2.repository.VinylRepository;
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
public class VinylRepositoryTest {
    
    private static Long id;
    private static ApplicationContext ctx;
    
    private static VinylRepository repo;
    
    public VinylRepositoryTest() {
    }

    @Test 
    public static void createVinyl(){
        repo = ctx.getBean(VinylRepository.class);
        
        List<Song> songs = new ArrayList<>();
        
        Song s = new Song.Builder(6)
                .setTitle("Don't Pray For me")
                .build();
        
        songs.add(s);
        
        Vinyl v = new Vinyl.Builder("Asking Alexandria")
                .setSongList(songs)
                .build();
        
        Assert.assertNotNull(v.getArtist());
        
        repo.save(v);
        id = v.getID();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createVinyl")
    public static void readVinyl(){
        repo = ctx.getBean(VinylRepository.class);
        Vinyl v = repo.findOne(id);
        Assert.assertEquals(v.getArtist(), "Asking Alexandria");
       
    }
    
    @Test(dependsOnMethods = "createVinyl")
    public static void updateVinyl(){
        repo = ctx.getBean(VinylRepository.class);
        Vinyl v = repo.findOne(id);
        
            Vinyl update = new Vinyl.Builder("Asking Alexandria")
                    .Vinyl(v)
                    .build();
            
            repo.save(update);
    }
    
    @Test(dependsOnMethods = "readVinyl")
    public static void deleteVinyl(){
        repo = ctx.getBean(VinylRepository.class);
        repo.delete(id);
        Vinyl v = repo.findOne(id);
        Assert.assertNull(v);
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

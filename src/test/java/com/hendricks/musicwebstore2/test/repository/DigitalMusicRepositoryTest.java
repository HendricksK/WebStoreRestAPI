/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.repository;


import com.hendricks.musicwebstore2.test.ConnectionConfigTest;
import com.hendricks.musicstoreweb2.domain.DigitalMusic;
import com.hendricks.musicstoreweb2.domain.Song;
import com.hendricks.musicstoreweb2.repository.DigitalMusicRepository;
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
public class DigitalMusicRepositoryTest {
    
    private static Long id;
    private static ApplicationContext ctx;
    
    private static DigitalMusicRepository repo;
    
    
    public DigitalMusicRepositoryTest() {
    }

    @Test 
    public static void createDM(){
        repo = ctx.getBean(DigitalMusicRepository.class);
        
        List<Song> songs = new ArrayList<>();
        
        Song s  = new Song.Builder(1)
                .setTitle("New Moon Rising")
                .build();
        
        songs.add(s);
        
        DigitalMusic dm = new DigitalMusic.Builder("Wolfmother")
                .setSongList(songs)
                .build();
        
        repo.save(dm);
        id = dm.getId();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createDM", enabled = false)
    public static void readDM(){
        repo = ctx.getBean(DigitalMusicRepository.class);
        DigitalMusic dm = repo.findOne(id);
        Assert.assertEquals(dm.getArtist(), "Wolfmother");
       
    }
    
    @Test(dependsOnMethods = "createDM", enabled = false)
    public static void updateDM(){
        repo = ctx.getBean(DigitalMusicRepository.class);
        DigitalMusic dm = repo.findOne(id);
        
            DigitalMusic update = new DigitalMusic.Builder("Asking Alexandria")
                    .DigitalMusic(dm)
                    .build();
            
            repo.save(update);
    }
    
    @Test(dependsOnMethods = "readDM")
    public static void deleteDM(){
        repo = ctx.getBean(DigitalMusicRepository.class);
        repo.delete(id);
        DigitalMusic dm = repo.findOne(id);
        Assert.assertNull(dm);
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new AnnotationConfigApplicationContext(ConnectionConfigTest.class);
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

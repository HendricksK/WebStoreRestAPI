/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.repository;


import com.hendricks.musicwebstore2.test.ConnectionConfigTest;
import com.hendricks.musicstoreweb2.domain.CD;
import com.hendricks.musicstoreweb2.domain.Song;
import com.hendricks.musicstoreweb2.repository.CDRepository;
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
public class CDRepositoryTest {
    
    private static Long id;
    private static ApplicationContext ctx;
    
    private static CDRepository repo;
    
    public CDRepositoryTest() {
    }

     @Test 
    public static void createCD(){
        repo = ctx.getBean(CDRepository.class);
        
        List<Song> songs = new ArrayList<>();
        
        Song s  = new Song.Builder(1)
                .setTitle("Always")
                .build();
        
        songs.add(s);
        
        CD cd = new CD.Builder("Killswitch Engage")
                .setSongList(songs)
                .build();
        
        repo.save(cd);
        id = cd.getId();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods = "createCD", enabled = false)
    public static void readCD(){
        repo = ctx.getBean(CDRepository.class);
        CD cd = repo.findOne(id);
        Assert.assertEquals(cd.getArtist(), "Killswitch Engage");
       
    }
    
    @Test(dependsOnMethods = "createCD", enabled = false)
    public static void updateCD(){
        repo = ctx.getBean(CDRepository.class);
        CD cd = repo.findOne(id);
        
            CD update = new CD.Builder("Slipknot")
                    .CD(cd)
                    .build();
            
            repo.save(update);
    }
    
    @Test(dependsOnMethods = "readCD")
    public static void deleteCD(){
        repo = ctx.getBean(CDRepository.class);
        repo.delete(id);
        CD cd = repo.findOne(id);
        Assert.assertNull(cd);
        
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

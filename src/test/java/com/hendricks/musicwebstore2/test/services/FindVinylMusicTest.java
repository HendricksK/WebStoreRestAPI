/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.services;

import com.hendricks.musicstoreweb2.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb2.repository.VinylRepository;
import com.hendricks.musicstoreweb2.services.FindVinylMusicService;
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
public class FindVinylMusicTest {
    private static ApplicationContext ctx;
    private VinylRepository repo;
    private FindVinylMusicService service;
    
    public FindVinylMusicTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void findVinyl() {
        service = ctx.getBean(FindVinylMusicService.class);
        repo = ctx.getBean(VinylRepository.class);
        String artist = service.searchVinyl("Macklemore");
        repo.deleteAll();
        Assert.assertEquals(artist, "Macklemore");
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

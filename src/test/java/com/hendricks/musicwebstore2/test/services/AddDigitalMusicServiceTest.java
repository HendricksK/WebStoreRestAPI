/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.services;

import com.hendricks.musicstoreweb2.domain.Song;
import com.hendricks.musicstoreweb2.repository.DigitalMusicRepository;
import com.hendricks.musicstoreweb2.services.AddDigitalMusicService;
import com.hendricks.musicwebstore2.test.ConnectionConfigTest;
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
public class AddDigitalMusicServiceTest {
    private DigitalMusicRepository repo;
    private static ApplicationContext ctx;
    private AddDigitalMusicService service;
    
    public AddDigitalMusicServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void hello() {
        service = ctx.getBean(AddDigitalMusicService.class);
        repo = ctx.getBean(DigitalMusicRepository.class);
        List<Song> songs = new ArrayList();
        boolean check = service.addMusic(songs, 78.45, "Armageddon");
        repo.deleteAll();
        Assert.assertEquals(check, true);
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

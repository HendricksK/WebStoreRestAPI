/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.services;

import com.hendricks.musicstoreweb2.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb2.repository.ArtistRepository;
import com.hendricks.musicstoreweb2.services.AddArtistService;
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
public class AddArtistServiceTest {
    private static ArtistRepository repo;
    private static ApplicationContext ctx;
    private static AddArtistService service;
    
    public AddArtistServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void artist() {
        service = ctx.getBean(AddArtistService.class);
        repo = ctx.getBean(ArtistRepository.class);
        boolean check = service.addMusic("Red Hot Chilli Peppers");
        repo.deleteAll();
        Assert.assertEquals(check, true);
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

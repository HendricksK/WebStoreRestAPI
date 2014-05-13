/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.services;

import com.hendricks.musicwebstore2.test.ConnectionConfigTest;
import com.hendricks.musicstoreweb2.repository.ListeningStationRepository;
import com.hendricks.musicstoreweb2.services.AddMusicListeningStationService;
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
public class AddMusicListeningStationServiceTest {
    private static ApplicationContext ctx;
    private ListeningStationRepository repo;
    private AddMusicListeningStationService service;
    
    public AddMusicListeningStationServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void addMusic() {
        service = ctx.getBean(AddMusicListeningStationService.class);
        repo = ctx.getBean(ListeningStationRepository.class);
        boolean check = service.addMusic("88");
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

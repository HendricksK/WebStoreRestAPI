/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.services;

import com.hendricks.musicstoreweb2.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb2.repository.VinylRepository;
import com.hendricks.musicstoreweb2.services.AddVinylService;
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
public class AddVinylServiceTest {
    private static ApplicationContext ctx;
    private static VinylRepository repo;
    private AddVinylService service;
    
    public AddVinylServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void vinyl() {
        service = ctx.getBean(AddVinylService.class);
        repo = ctx.getBean(VinylRepository.class);
        boolean check = service.addMusic("Get a Grip");
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

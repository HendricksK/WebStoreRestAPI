/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.repository;

import com.hendricks.musicstoreweb2.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb2.domain.ListeningStation;
import com.hendricks.musicstoreweb2.repository.ListeningStationRepository;
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
public class ListeningStaionRepositoryTest {
    
    private static ApplicationContext ctx;
    private static Long id;
    private static ListeningStationRepository repo;
    
    
    public ListeningStaionRepositoryTest() {
    }
    
    @Test
    public static void createLS(){
        repo = ctx.getBean(ListeningStationRepository.class);
        
        ListeningStation ls = new ListeningStation.Builder("Billy Talent II")
                .build();
        
        repo.save(ls);
        id = ls.getID();
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods="createLS")
    public static void readLS(){
        repo = ctx.getBean(ListeningStationRepository.class);
        ListeningStation ls = repo.findOne(id);
        
        Assert.assertEquals(ls.getAlbum(), "Billy Talent II");
    }
    
    @Test(dependsOnMethods="createLS")
    public static void updateLS(){
        repo = ctx.getBean(ListeningStationRepository.class);
        ListeningStation ls = repo.findOne(id);
        
        ListeningStation update = new ListeningStation.Builder("Billy Talent III")
                .ListeningStation(ls)
                .build();
        
        repo.save(update);
    }
    
    @Test(dependsOnMethods="readLS")
    public static void deleteLS(){
        repo = ctx.getBean(ListeningStationRepository.class);
        repo.delete(id);
        ListeningStation ls = repo.findOne(id);
        
        Assert.assertNull(ls);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.repository;


import com.hendricks.musicstoreweb2.app.conf.ConnectionConfig;
import com.hendricks.musicstoreweb2.domain.Manager;
import com.hendricks.musicstoreweb2.domain.ProductBuyer;
import com.hendricks.musicstoreweb2.repository.ManagerRepository;
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
public class ManagerRepositoryTest {
    
    private static ApplicationContext ctx;
    private static Long id;
    private static ManagerRepository repo;
    
    public ManagerRepositoryTest() {
    }
    
    @Test
    public static void createManager(){
        repo = ctx.getBean(ManagerRepository.class);
        
        Manager m = new Manager.Builder("Martin Metallica")
                .build();
        
        repo.save(m);
        id = m.getID();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods="createManager")
    public static void readManager(){
        repo = ctx.getBean(ManagerRepository.class);
        
        Manager m = repo.findOne(id);
        Assert.assertEquals(m.getName(), "Martin Metallica");
    }
    
    @Test(dependsOnMethods="createManager")
    public static void updateManager(){
        repo = ctx.getBean(ManagerRepository.class);
        
        Manager m = repo.findOne(id);
        
        List<ProductBuyer> pb = new ArrayList<>();
        
        Manager update = new Manager.Builder(m.getName())
                .setBuyerList(pb)
                .Manager(m)
                .build();
        
        repo.save(update);
    }
    
    @Test(dependsOnMethods="readManager")
    public static void deleteManager(){
        repo = ctx.getBean(ManagerRepository.class);
        repo.delete(id);
        
        Manager m = repo.findOne(id);
        Assert.assertNull(m);
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

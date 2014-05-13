/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.repository;


import com.hendricks.musicwebstore2.test.ConnectionConfigTest;
import com.hendricks.musicstoreweb2.domain.DeviceSupplier;
import com.hendricks.musicstoreweb2.domain.MediaSupplier;
import com.hendricks.musicstoreweb2.domain.ProductBuyer;
import com.hendricks.musicstoreweb2.repository.ProductBuyerRepository;
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
public class ProductBuyerRepositoryTest {
    
    private static ApplicationContext ctx;
    private static Long id;
    private static ProductBuyerRepository repo;
    
    public ProductBuyerRepositoryTest() {
    }
    
    @Test
    public static void createPB(){
        repo = ctx.getBean(ProductBuyerRepository.class);
        
        ProductBuyer pb = new ProductBuyer.Builder("Johnathan McIntire")
                .build();
        
        repo.save(pb);
        id = pb.getID();
        
        Assert.assertNotNull(id);
    }
    
    @Test(dependsOnMethods="createPB")
    public static void readPB(){
        repo = ctx.getBean(ProductBuyerRepository.class);
        
        ProductBuyer pb = repo.findOne(id);
        
        Assert.assertEquals(pb.getID(), id);
    }
    
    @Test(dependsOnMethods="createPB")
    public static void updatePB(){
        repo = ctx.getBean(ProductBuyerRepository.class);
        
        ProductBuyer pb = repo.findOne(id);
        
        List<DeviceSupplier> ds = new ArrayList<>();
        List<MediaSupplier> ms = new ArrayList<>();
        
        ProductBuyer update = new ProductBuyer.Builder("Claudio")
                .setDeviceSuppList(ds)
                .setMediaSuppList(ms)
                .ProductBuyer(pb)
                .build();
        
        repo.save(update);
    }
    
    @Test(dependsOnMethods="readPB")
    public static void deletePB(){
        repo = ctx.getBean(ProductBuyerRepository.class);
        repo.delete(id);
        ProductBuyer pb = repo.findOne(id);
        Assert.assertNull(pb);
        
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

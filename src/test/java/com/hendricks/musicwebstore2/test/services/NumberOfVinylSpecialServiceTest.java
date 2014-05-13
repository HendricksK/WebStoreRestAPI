/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.services;

import com.hendricks.musicwebstore2.test.ConnectionConfigTest;
import com.hendricks.musicstoreweb2.repository.ProductPurchaseRepository;
import com.hendricks.musicstoreweb2.services.NumberOfVinylSpecialsService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author kurvin
 */
public class NumberOfVinylSpecialServiceTest {
    
    private static ApplicationContext ctx;
    private NumberOfVinylSpecialsService service;
    private ProductPurchaseRepository repo;
    
    public NumberOfVinylSpecialServiceTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void special() {
         service = ctx.getBean(NumberOfVinylSpecialsService.class);
         repo = ctx.getBean(ProductPurchaseRepository.class);
         int check = service.numberOfSpecials(4.00);
         repo.deleteAll();
         Assert.assertEquals(check, 1);
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

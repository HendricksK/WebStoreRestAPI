/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.restapi;

import com.hendricks.musicstoreweb2.domain.DigitalMusic;
import java.util.Collections;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Kurvin Hendricks
 */
public class RestDigitalMusicTest {
    
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String URL = "http://localhost:8081/MusicStoreWeb2/";
    
    public RestDigitalMusicTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
     public void create(){
         DigitalMusic dg = new DigitalMusic.Builder("Hogg Hoggidy Hogg").build();
         HttpEntity<DigitalMusic> requestEntity = new HttpEntity<>(dg, getContentType());
         ResponseEntity<String> responseEntity = restTemplate.exchange(URL+"api/digimuse/create", HttpMethod.POST, requestEntity, String.class);
         Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
     }
     
     @Test
     public void update(){
         DigitalMusic dg = new DigitalMusic.Builder("Hogg Hoggidy Hogg").build();
         HttpEntity<DigitalMusic> requestEntity = new HttpEntity<>(dg, getContentType());
         ResponseEntity<String> responseEntity = restTemplate.exchange(URL+"api/digimuse/update", HttpMethod.PUT, requestEntity, String.class);
         Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
     }

    @BeforeClass
    public static void setUpClass() throws Exception {
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
    
    public HttpEntity<?> getHttpEntity(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Collections.singletonList(new MediaType("application","json")));
        HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
    
    public HttpHeaders getContentType(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;
    }
}

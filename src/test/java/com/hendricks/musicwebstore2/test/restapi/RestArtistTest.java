/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicwebstore2.test.restapi;

import com.hendricks.musicstoreweb2.domain.Artist;
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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Kurvin Hendricks
 */
public class RestArtistTest {
    
    private final RestTemplate restTemp = new RestTemplate();
    private final static String URL = "http://localhost:8081/MusicStoreWeb2/";
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    public RestArtistTest(){};
    
     @Test
     public void create() {
         Artist artist = new Artist.Builder("redbull").build();
         HttpEntity<Artist> requestEntity = new HttpEntity<>(artist, getContentType());
         ResponseEntity<String> responseEntity = restTemp.exchange(URL+"api/artist/create", HttpMethod.POST, requestEntity, String.class);
         Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
     }
     
     @Test
     public void update(){
         Artist artist = new Artist.Builder("Flobots").build();
         HttpEntity<Artist> requestEntity = new HttpEntity<>(artist, getContentType());
         ResponseEntity<String> responseEntity = restTemp.exchange(URL+"api/artist/update", HttpMethod.PUT, requestEntity, String.class);
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
        restTemp.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return requestEntity;
    }
    
    public HttpHeaders getContentType(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(new MediaType("application", "json"));
        return requestHeaders;
    }
}

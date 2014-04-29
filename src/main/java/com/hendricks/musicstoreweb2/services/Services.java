/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services;

import java.util.List;

/**
 *
 * @author kurvin
 */
public interface Services <S, ID>{
    
    public S find(ID id);
    
    public S persists(S entity);
    
    public S merge(S entity);
    
    public void remove(S entity);
    
    public List<S> findAll();
}

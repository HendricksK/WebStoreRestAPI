/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.Manager;
import com.hendricks.musicstoreweb2.domain.ProductBuyer;
import com.hendricks.musicstoreweb2.repository.ManagerRepository;
import com.hendricks.musicstoreweb2.services.AddManagerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class AddManagerServiceImpl implements AddManagerService{
@Autowired
    private  ManagerRepository repo;
    private  Long id;
    
    @Override
    public boolean addManager(String name, List<ProductBuyer> buyers) {
        Manager m = new Manager.Builder(name)
                .setBuyerList(buyers)
                .build();
        
        repo.save(m);
        id = m.getID();
        
        Manager m1 = repo.findOne(id);
        
        if(m.equals(m1)){
            return true;
        }else return false;
    }

    @Override
    public Manager find(Long id) {
        return repo.findOne(id);
    }

    @Override
    public Manager persists(Manager entity) {
        return repo.save(entity);
    }

    @Override
    public Manager merge(Manager entity) {
        if(entity.getID()!=null){
            return repo.save(entity);
        }else return null;
    }

    @Override
    public void remove(Manager entity) {
       repo.delete(entity);
    }

    @Override
    public List<Manager> findAll() {
       return repo.findAll();
    }
    
}

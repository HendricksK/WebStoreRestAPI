/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hendricks.musicstoreweb2.services.Impl;

import com.hendricks.musicstoreweb2.domain.DeviceSupplier;
import com.hendricks.musicstoreweb2.domain.MediaSupplier;
import com.hendricks.musicstoreweb2.domain.ProductBuyer;
import com.hendricks.musicstoreweb2.repository.ProductBuyerRepository;
import com.hendricks.musicstoreweb2.services.AddProductBuyerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 *
 * @author kurvin
 */
@Service
public class AddProductBuyerServiceImpl implements AddProductBuyerService{
    @Autowired
    private ProductBuyerRepository repo;
    private Long id;
    
    @Override
    public boolean addManager(String name, List<DeviceSupplier> dList, List<MediaSupplier> mList) {
       
        ProductBuyer pb = new ProductBuyer.Builder(name)
                .setDeviceSuppList(dList)
                .setMediaSuppList(mList)
                .build();
        
        repo.save(pb);
        id = pb.getID();
        
        ProductBuyer pb1 = repo.findOne(id);
        
        if(pb1.equals(pb)){
            return true;
        }else return false;
    }

    @Override
    public ProductBuyer find(Long id) {
        return repo.findOne(id);
    }

    @Override
    public ProductBuyer persists(ProductBuyer entity) {
        return repo.save(entity);
    }

    @Override
    public ProductBuyer merge(ProductBuyer entity) {
        if(entity.getID()!=null){
            return repo.save(entity);
        }else return null;
    }

    @Override
    public void remove(ProductBuyer entity) {
        repo.delete(entity);
    }

    @Override
    public List<ProductBuyer> findAll() {
        return repo.findAll();
    }
    
}

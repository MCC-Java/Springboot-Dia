/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.services;

import com.mcc.crud.entities.Region;
import com.mcc.crud.repositories.RegionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author yosef
 */
@Service
public class RegionService{
    @Autowired
    RegionRepository regionRepository;
     //read
    public List<Region> getAll(){
     return regionRepository.findAll();
    }
    //create/update
    public void save(Region region){
        regionRepository.save(region);
        
    }
    //delete
    public void delete(Integer id){
        regionRepository.delete(new Region(id));
    }
    
    //search
    public Region getById(Integer id){
        return regionRepository.findById(id).get();
    }
}

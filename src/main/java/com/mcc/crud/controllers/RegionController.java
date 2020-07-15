/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcc.crud.controllers;

import com.mcc.crud.entities.Region;
import com.mcc.crud.services.RegionService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author yosef
 */
@Controller
public class RegionController {
    @Autowired
    RegionService regionService;
    
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("region", new Region());
        model.addAttribute("regions", regionService.getAll());
        return "index";
    }
    
    @PostMapping("/save") //gabungan antara create dan update
    public String save(@Valid Region region){
        regionService.save(region);
        return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String delete (Model model, @PathVariable("id") String id){
        regionService.delete(Integer.parseInt(id));
        return "redirect:/";
    }
    
    @GetMapping("{id}")
    public String getById(Model model, @PathVariable("id") String id){
        model.addAttribute("region", regionService.getById(Integer.parseInt(id)));
        model.addAttribute("regions", regionService.getAll());
        return "index";
    }
            
}

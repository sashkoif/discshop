package com.test.discshop.controller;

import java.util.List;

import com.test.discshop.domain.Disk;
import com.test.discshop.service.DiskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DiskController {
    @Autowired 
    private DiskService diskService;

    @GetMapping(value ="/disk")
    public List<Disk> getAllDisks() {
        return diskService.findAllDisks();
    }

    @PostMapping(value ="/disk")
    public void addNewDisk(@RequestBody Disk disk) {
        diskService.addNewDisk(disk);
    }

    @GetMapping(value ="/available-disk")
    public List<Disk> getAvailableTakenItems() {
        return diskService.getAvailableDisks();
    }   
}
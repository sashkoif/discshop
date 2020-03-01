package com.test.discshop.controller;

import java.util.List;

import com.test.discshop.domain.Disk;
import com.test.discshop.domain.TakenItem;
import com.test.discshop.service.TakenItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TakenItemController {
    @Autowired 
    private TakenItemService takenItemService;
    
    @GetMapping(value ="/taken-items-by-current-user")
    public List<TakenItem> getTakenItemsByCurrentUser(OAuth2Authentication auth) {
        return takenItemService.takenItemsByCurrentUser((String) auth.getPrincipal());
    }

    @GetMapping(value ="/taken-items")
    public List<TakenItem> getTakenItemsByUsers() {
        return takenItemService.takenItemsByUsers();
    }

    @PostMapping(value ="/taken-items")
    public void addTakenItem(@RequestBody Disk disk, OAuth2Authentication auth) {
        takenItemService.addTakenItem((String) auth.getPrincipal(), disk);
    }

    @DeleteMapping(value ="/taken-items")
    public void removeTakenItem(@RequestBody Disk disk, OAuth2Authentication auth) {
        takenItemService.removeTakenItem((String) auth.getPrincipal(), disk);
    }
}
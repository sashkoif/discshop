package com.test.discshop.controller;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.discshop.CookieCollector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ViewController {
    @Autowired
    CookieCollector cookieCollector;

    @GetMapping("/")
    public String index(Model model, 
                        HttpServletRequest request, 
                        HttpServletResponse response, 
                        @CookieValue(value = "session_id", required = false) String sessionId) {

        if (sessionId==null) {
            sessionId = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("session_id",sessionId);
            response.addCookie(cookie);
            return "login";
        } else {
            String tokenStr = cookieCollector.getLastToken(sessionId);
            if (tokenStr==null) {
                return "login";
            } else {
                model.addAttribute("token", tokenStr);		
                return "index";
            }
        }
    }
	
	@PostMapping("/")
    public String postIndex(Model model, 
                            @RequestBody String tokenStr, 
                            @CookieValue(value = "session_id") String sessionId) {
        cookieCollector.setNewCookie(sessionId, tokenStr);
        model.addAttribute("token", tokenStr);		
        return "index";
    }
}
package com.test.discshop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class CookieCollector {
    private Map<String,String> cookieCollectorMap;
    
    public CookieCollector() {
        cookieCollectorMap = new ConcurrentHashMap<String,String>();
	}
    
    public void setNewCookie(String session, String token){
		cookieCollectorMap.put(session, token);
	}

	public String getLastToken(String session){
		return cookieCollectorMap.get(session);
	}

	
}
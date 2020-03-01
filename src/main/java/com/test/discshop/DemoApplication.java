package com.test.discshop;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static Map<String,String> cookieCollector;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		cookieCollector = new ConcurrentHashMap<String,String>();
	}

	public static void setNewCookie(String session, String token){
		cookieCollector.put(session, token);
	}

	public static String getLastToken(String session){
		return cookieCollector.get(session);
	}
}

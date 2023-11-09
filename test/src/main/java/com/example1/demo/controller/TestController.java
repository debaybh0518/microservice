package com.example1.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	RestTemplate template;

	@GetMapping("/add")
	public String add() {
		return sample();
	}
	
	public String sample() {
		return "Hi";
	}

	@GetMapping("/merge")
	public String merge() throws URISyntaxException {		
	URI url = new URI("http://localhost:8081/test2/add");
	ResponseEntity<String> forEntity = template.getForEntity(url, String.class);
	String body = forEntity.getBody();
	System.out.println(body);
	return sample()+ " " + body;	
	}
}

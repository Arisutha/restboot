package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ResponseEntity<String> toHome(){
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);
	}
}

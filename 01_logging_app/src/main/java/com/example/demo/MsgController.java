package com.example.demo;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.classic.Logger;

@RestController
public class MsgController {
private org.slf4j.Logger logger=LoggerFactory.getLogger(MsgController.class);
@GetMapping("/welcome")
public String getMsg() {
	logger.info("getMsg - execution Started");
	String msg = "Welcome to Sri Sai hostel";
	try {
		int i=10/0;
	} catch (Exception e ) {
		logger.error("Exception :"+e.getMessage());
	}
	logger.info("getMsg - execution Ended");
	
	return msg;
	
}


}

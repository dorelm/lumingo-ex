package com.example.springboot;

import com.example.springboot.dataModel.PostMessage;
import com.example.springboot.dataModel.Statistics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/statistics")
	public Statistics statistics() {
		return Application.functionsManager.getStatistics();
	}

	@PostMapping("/messages")
	void newMessage(@RequestBody PostMessage postMessage) {
		Application.functionsManager.newMessage(postMessage);
	}


}

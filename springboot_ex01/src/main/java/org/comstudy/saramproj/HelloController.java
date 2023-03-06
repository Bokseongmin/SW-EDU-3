package org.comstudy.saramproj;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String hello(Model model) {
		model.addAttribute("msg", "Hello world");
		return "home";
	}
	
	public String hello2() {
		return "hello2";
	}
}

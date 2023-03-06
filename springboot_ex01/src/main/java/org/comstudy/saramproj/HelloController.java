package org.comstudy.saramproj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
	
	@GetMapping("/")
	public String hello(Model model) {
		model.addAttribute("msg", "Hello world");
		return "home";
	}
	
	@GetMapping("hello2")
	public String hello2() {
		return "index";
	}
}

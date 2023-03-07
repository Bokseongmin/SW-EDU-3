package org.comstudy.saramproj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
	
	@GetMapping("/")
	public String index() {
		// thymeleaf 사용 시 src/main/resources/template가 기본 뷰 폴더
		return "index";
	}
}

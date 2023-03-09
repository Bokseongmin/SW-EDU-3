package org.comstudy.todo.controller;

import org.comstudy.todo.dto.TestRequestBodyDTO;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/")
	public String hello() {
		// 리턴되는 문자열이 브라우저에 바로 출력 된다.
		return "{\"message\":\"Hello Comstudy School\"}";
	}

	@PostMapping("/hello")
	public String helloProc(@RequestParam("user") String user, @RequestParam("message") String message) {
		return String.format("{\"user\":\"%s\",\"message\":\"%s\"}", user, message);
	}

	@GetMapping("/saram/{id}/{message}")
	public String pathVariables(@PathVariable(required = true) String id, @PathVariable String message) {
		// JSONObject 라이브러리 활용;
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("no", 1);
		jsonObj.put("id", id);
		jsonObj.put("message", message);
		return jsonObj.toString(2);
	}

	@GetMapping("/requestBody")
	public String testRequestBody(@RequestBody TestRequestBodyDTO reqDTO) {
		return reqDTO.toString();
	}
	
	@GetMapping("/requestBody2")
	public TestRequestBodyDTO testRequestBodyDTO(@RequestBody TestRequestBodyDTO reqDTO) {
		return reqDTO;
	}
}

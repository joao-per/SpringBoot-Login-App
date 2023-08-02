package com.empego.logintemplate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
	@RequestMapping("/")
	public String showLoginPage() {
		return "index.html";
	}
}

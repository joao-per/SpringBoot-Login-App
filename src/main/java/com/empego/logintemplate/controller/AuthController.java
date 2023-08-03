package com.empego.logintemplate.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.empego.logintemplate.dto.UserDto;
import com.empego.logintemplate.entity.User;
import com.empego.logintemplate.service.UserService;

import java.util.List;

@Controller
public class AuthController {

	private UserService userService;

	public AuthController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("index")
	public String home(){
		return "index";
	}

	@GetMapping("/login")
	public String loginForm(Model model) {
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "login";
	}

	// handler method to handle user registration request
	@GetMapping("/register")
	public String showRegistrationForm(Model model){
		UserDto user = new UserDto();
		model.addAttribute("user", user);
		return "register";
	}

	/**
	 * The function handles the registration process by validating user input, checking for existing
	 * accounts, and saving the user if there are no errors.
	 */
	@PostMapping("/register/save")
	public String registration(@Valid @ModelAttribute("user") UserDto user,
							   BindingResult result,
							   Model model){
		User existing = userService.findByEmail(user.getEmail());
		if (existing != null) {
			result.rejectValue("email", null, "There is already an account registered with that email");
		}
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			return "register";
		}
		userService.saveUser(user);
		return "redirect:/register?success";
	}

	/**
	 * The function retrieves a list of registered users and adds it to the model before returning the
	 * "users" view.
	 */
	@GetMapping("/users")
	public String listRegisteredUsers(Model model){
		List<UserDto> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "users";
	}
}


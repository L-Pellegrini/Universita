package it.uniroma3.spring.snake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContextHolder;
import it.uniroma3.spring.snake.model.Player;

@Controller
public class MainController {

	 // Login form
	  @GetMapping("/loginUser")
	  public String login(Model model) {
		  return "loginUser";
	  }
	  
	  // Logout page rediection
	  @RequestMapping("/logout")
	  public String logout() {
		  return "index";
	  }
	  
	  @RequestMapping("/register")
	  public String register(Model model) {
		  model.addAttribute("player", new Player());
		  return "register";
	  }
}

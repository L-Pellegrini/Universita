package it.uniroma3.spring.snake.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
	  
	  @RequestMapping("/confirm")
	  public String confimUser(@Valid @ModelAttribute Player player, 
				BindingResult bindingResult, HttpSession httpSession) {
		  if(bindingResult.hasErrors()) {
			  return "register";
		  } else {
			  httpSession.setAttribute("player", player);
			  return "confirmation";
		  }
	  }
}

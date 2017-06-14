package it.uniroma3.spring.snake.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import it.uniroma3.spring.snake.service.PlayerService;
import it.uniroma3.spring.snake.model.Player;
import it.uniroma3.spring.snake.repository.RoleRepository;

@Controller
public class UserController {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping("/user")
	public String registerUser(HttpSession httpSession) {
		
		Player player = (Player)httpSession.getAttribute("player");
		
		player.setRole(roleRepository.findByName("ROLE_USER"));
			
		String password = player.getPassword();
		player.setPassword(passwordEncoder.encode(password));
		playerService.add(player);
		return "loginUser";
	}
	
	@RequestMapping("/profile")
	public String viewUserPage(Model model) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Player player = playerService.findbyUsername(username);
		model.addAttribute("player", player);
		return "profile";
	}
}

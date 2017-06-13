package it.uniroma3.spring.snake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.spring.snake.model.Player;
import it.uniroma3.spring.snake.repository.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	public Iterable<Player> findAll() {
		return this.playerRepository.findAll();
	}
	
	@Transactional
	public void add(final Player player) {
		this.playerRepository.save(player);
	}
	
	public Player findbyId(Long id) {
		return this.playerRepository.findOne(id);
	}
	
	public Player findbyUsername(String username) {
		return this.playerRepository.findByUsername(username);
	}
	
	public Player findByEmail(String email) {
		return this.playerRepository.findByEmail(email);
	}
}

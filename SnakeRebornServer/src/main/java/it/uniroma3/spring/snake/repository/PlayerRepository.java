package it.uniroma3.spring.snake.repository;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.spring.snake.model.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

	public Player findByUsername(String username);
	
	public Player findByEmail(String email);
}

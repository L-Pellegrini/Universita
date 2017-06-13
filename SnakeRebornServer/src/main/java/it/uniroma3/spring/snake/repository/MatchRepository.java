package it.uniroma3.spring.snake.repository;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.spring.snake.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long>{
	
	
}

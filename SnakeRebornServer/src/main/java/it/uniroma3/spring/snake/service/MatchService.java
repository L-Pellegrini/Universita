package it.uniroma3.spring.snake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.uniroma3.spring.snake.repository.MatchRepository;
import it.uniroma3.spring.snake.model.Match;

@Service
public class MatchService {

	@Autowired
	private MatchRepository matchRepository;
	
}

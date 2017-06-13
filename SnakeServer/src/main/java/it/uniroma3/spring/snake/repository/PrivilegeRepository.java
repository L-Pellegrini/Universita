package it.uniroma3.spring.snake.repository;

import org.springframework.data.repository.CrudRepository;
import it.uniroma3.spring.snake.model.Privilege;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long>{

	public Privilege findByName(String name);
}

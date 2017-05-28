package repository;

import javax.persistence.EntityManager;
import model.Player;

public class PlayerRepository extends CrudRepositoryJPA<Player> {

	public PlayerRepository(EntityManager em) {
		super(em, Player.class);
	}
}

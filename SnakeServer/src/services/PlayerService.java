package services;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import model.Player;
import repository.PlayerRepository;

public class PlayerService {
	
	private EntityManager em;

	public PlayerService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("snake-unit");
		this.em = emf.createEntityManager();
	}
	
	public Player addPlayer(Player player) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		PlayerRepository pr = new PlayerRepository(this.em);
		pr.save(player);
		tx.commit();
		return player;
	}
	
	public Player getPlayer(long id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		PlayerRepository pr = new PlayerRepository(this.em);
		Player player = pr.findOne(id);
		tx.commit();
		return player;
	}
	
	public List<Player> getAllPlayer() {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		PlayerRepository pr = new PlayerRepository(this.em);
		List<Player> players = pr.findAll();
		tx.commit();
		return players;
	}
	
	public void removePlayer(long id) {
		EntityTransaction tx = this.em.getTransaction();
		tx.begin();
		PlayerRepository pr = new PlayerRepository(this.em);
		pr.delete(this.getPlayer(id));
		tx.commit();
	}
}

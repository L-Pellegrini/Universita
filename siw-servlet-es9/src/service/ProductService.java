package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import model.Prodotto;
import repository.ProductRepository;

public class ProductService {
	
	private EntityManager em;
	
	public ProductService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("prodotto-unit");
		this.em = emf.createEntityManager();
	}
	
	public Prodotto inserisciProdotto(Prodotto prodotto) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ProductRepository productRepo = new ProductRepository(this.em);
		productRepo.save(prodotto);
		tx.commit();
		return prodotto;
	}

	public List<Prodotto> getProdotti() {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ProductRepository productRepo = new ProductRepository(this.em);
		List<Prodotto> prodotti = productRepo.findAll();
		tx.commit();
		return prodotti;
	}
	
	public Prodotto getOneProdotto(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ProductRepository productRepo = new ProductRepository(this.em);
		Prodotto prodotto = productRepo.findOne(id);
		tx.commit();
		return prodotto;
	}
	
	public void deleteProdotto(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		ProductRepository productRepo = new ProductRepository(this.em);
		Prodotto prodotto = productRepo.findOne(id);
		productRepo.delete(prodotto);
		tx.commit();
	}
}

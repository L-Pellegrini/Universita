package repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import model.Prodotto;

public class ProductRepository extends CrudRepositoryJPA<Prodotto> {

	public ProductRepository(EntityManager em) {
		super(em, Prodotto.class);
	}
	
	/*
	@Override
	public List<Prodotto> findAll() {
		TypedQuery<Prodotto> query = super.getEm().createNamedQuery("findAll", Prodotto.class);
		List<Prodotto> prodotti = query.getResultList();
		return prodotti;
	}
	*/
}

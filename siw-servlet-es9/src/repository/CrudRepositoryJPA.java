package repository;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CrudRepositoryJPA<T> implements CrudRepository<T> {
	private EntityManager em;
	private Class<T> entityClass; 
	
	public CrudRepositoryJPA(EntityManager em, Class<T> entityClass) {
		this.em = em;
		this.entityClass = entityClass;
	}
	
	@Override
	public T save(T entity) {
		Method getId = null;
		T persistenEntity = null;
		
		try {
			getId = this.entityClass.getMethod("getId");
		} catch(NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			if(getId.invoke(entity) == null) {
				this.em.persist(entity);
				persistenEntity = this.em.merge(entity);
			}
		} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return persistenEntity;
	}

	@Override
	public T findOne(long id) {
		return em.find(this.entityClass, id);
	}

	@Override
	public List<T> findAll() {
		TypedQuery<T> query = em.createNamedQuery("findAll", this.entityClass);
		List<T> resultList = query.getResultList();
		return resultList;
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	protected EntityManager getEm() {
		return this.em;
	}
}

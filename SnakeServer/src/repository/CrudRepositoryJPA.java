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
		T peristentEntity = null;
		
		try {
			getId = this.entityClass.getMethod("getId");
		} catch(NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		try {
			if(getId.invoke(entity) == null) {
				this.em.persist(entity);
				peristentEntity = entity;
			} else {
				peristentEntity = this.em.merge(entity);
			}
		} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return peristentEntity;
	}
	
	@Override
	public T findOne(long id) {
		return this.em.find(this.entityClass, id);
	}
	
	@Override
	public List<T> findAll() {
		TypedQuery<T> query = this.em.createNamedQuery("findAll", this.entityClass);
		List<T> resutlList = query.getResultList();
		return resutlList;
	}
	
	@Override
	public void delete(T entity) {
		this.em.remove(entity);
	}
}

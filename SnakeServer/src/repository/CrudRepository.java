package repository;

import java.util.List;

public interface CrudRepository<T> {
	
	public T save(T entity);
	public T findOne(long id);
	public List<T> findAll();
	public void delete(T entity);
}

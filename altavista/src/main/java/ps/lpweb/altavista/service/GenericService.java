package ps.lpweb.altavista.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class GenericService<T> {
	
	private Class<T> entity;
	
	public GenericService(Class<T> entity) {
		
		this.setEntity(entity);
	}
	
	public void salvar(T entity) {
		
		try {
			
			getEntityManager().getTransaction().begin();
			getEntityManager().persist(entity);
			getEntityManager().getTransaction().commit();
			
		} catch (IllegalArgumentException ex) {
			
			getEntityManager().getTransaction().rollback();
		}
	}
	
	public T alterar(T entity) {
		
		T temp = null;
		
		try {
			
			getEntityManager().getTransaction().begin();
			temp = getEntityManager().merge(entity);
			getEntityManager().getTransaction().commit();
		
		} catch (IllegalArgumentException ex) {
			
			getEntityManager().getTransaction().rollback();
		}
		
		return temp;
	}
	
	public T getById(int id) {
		
		T entity = getEntityManager().find(getEntity(), id);
		
		return entity;
	}
	
	public List<T> getAll() {
		
		List<T> entities = null;
		
		try {
			
			getEntityManager().getTransaction().begin();
			
			CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();

			CriteriaQuery<T> criterios = builder.createQuery(getEntity());
			Root<T> table = criterios.from(getEntity());
			criterios.select(table).getOrderList();
			
			entities = getEntityManager().createQuery(criterios).getResultList();
			
			getEntityManager().getTransaction().commit();
			
		} catch (IllegalArgumentException ex) {
			
			getEntityManager().getTransaction().rollback();
		}
		
		return entities;
	}
	
	public T getByColumn(String key, String value) {
		
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		
		CriteriaQuery<T> criterios = builder.createQuery(getEntity());
		Root<T> table = criterios.from(getEntity());
		criterios.select(table).where(builder.equal(table.get(key), value));
		
		T entity = getEntityManager().createQuery(criterios).getSingleResult();
		
		return entity;
	}
	
	public void delete(T entity) {
		
		getEntityManager().remove(entity);
	}
	
	public Class<T> getEntity() {
		return entity;
	}

	public void setEntity(Class<T> entity) {
		this.entity = entity;
	}
	
	protected abstract EntityManager getEntityManager();
}

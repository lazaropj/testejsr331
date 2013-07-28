package br.com.linkout.DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class GenericDAO<T> implements Serializable {
	
	private static final long serialVersionUID = 5755734275570036760L;
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPAPU");
    private EntityManager em;

    private Class<T> entityClass;

    public void beginTransaction() {
            em = emf.createEntityManager();

            em.getTransaction().begin();
    }

    public void commit() {
            em.getTransaction().commit();
    }

    public void rollback() {
            em.getTransaction().rollback();
    }

    public void closeTransaction() {
            em.close();
    }

    public void commitAndCloseTransaction() {
            commit();
            closeTransaction();
    }

    public void flush() {
            em.flush();
    }

    public void joinTransaction() {
            em = emf.createEntityManager();
            em.joinTransaction();
    }

    public GenericDAO(Class<T> entityClass) {
            this.entityClass = entityClass;
    }

    public void save(T entity) {
            em.persist(entity);
    }

    public void delete(T entity) {
            T entityToBeRemoved = em.merge(entity);

            em.remove(entityToBeRemoved);
    }

    public T update(T entity) {
            return em.merge(entity);
    }

    public T find(Long entityID) {
            return em.find(entityClass, entityID);
    }

    public T findReferenceOnly(Long id) {
            return em.getReference(entityClass, id);
    }

    // Using the unchecked because JPA does not have a
    // em.getCriteriaBuilder().createQuery()<T> method
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findAll() {              
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(entityClass));
            return em.createQuery(cq).getResultList();
    }

    // Using the unchecked because JPA does not have a
    // query.getSingleResult()<T> method
    
    @SuppressWarnings("unchecked")
    protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
            T result = null;

            try {
                    Query query = em.createNamedQuery(namedQuery);

                    // Method that will populate parameters if they are passed not null and empty
                    if (parameters != null && !parameters.isEmpty()) {
                            populateQueryParameters(query, parameters);
                    }

                    result = (T) query.getSingleResult();

            } catch (NoResultException e) {
                    System.out.println("Nenhum resultado encontrado para consulta nomeada: " + namedQuery);
            } catch (Exception e) {
                    System.out.println("Erro ao executar consulta: " + e.getMessage());
                    e.printStackTrace();
            }

            return result;
    }

    private void populateQueryParameters(Query query, Map<String, Object> parameters) {
            for (Entry<String, Object> entry : parameters.entrySet()) {
                    query.setParameter(entry.getKey(), entry.getValue());
            }
    }

}
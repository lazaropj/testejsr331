package br.com.linkout.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FabricaDeConexao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJPAPU");
	
	public EntityManager getConexao(){
		return emf.createEntityManager();
	}
	
}

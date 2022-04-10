package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	static {
		if( entityManager == null ) {
			entityManagerFactory = Persistence.createEntityManagerFactory("DigimonPU");
			entityManager = entityManagerFactory.createEntityManager();
		}
	}

	public static EntityManager getEntityManager() {
		return entityManager;
	}
	
	public static void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}
	
}

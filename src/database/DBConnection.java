package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import calculator.domain.Pair;
import calculator.domain.OutputStat;

//manages the database connectivity and persistence logic
public class DBConnection {
	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	
	public DBConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("Regression Calculator");
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void persistPair(Pair input) {
		entityManager.getTransaction().begin();
		entityManager.persist(input);
		entityManager.getTransaction().commit();		
	}
	
	public void persistStats(OutputStat input) {
		entityManager.getTransaction().begin();
		entityManager.persist(input);
		entityManager.getTransaction().commit();
	}
	
	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
}

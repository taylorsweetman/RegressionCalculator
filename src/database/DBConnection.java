package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;
import calculator.domain.Pair;
import calculator.domain.OutputStat;

public class DBConnection {
	
	EntityManagerFactory entityManagerFactory;
	EntityManager entityManager;
	Session session;
	
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

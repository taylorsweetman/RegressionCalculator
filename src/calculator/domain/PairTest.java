package calculator.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.Entity;

public class PairTest {

	public static void main(String[] args) {
		Pair pair1 = new Pair(1, 1, 1);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Regression Calculator");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		entityManager.persist(pair1);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

		System.out.println("A Users Object was persisted");
	}
}

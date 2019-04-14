import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import calculator.domain.*;

public class PairTest {

	public static void main(String[] args) {
		Pair pair1 = new Pair();
		pair1.setX(1.0);
		pair1.setY(1.0);
		pair1.setIdx(1);

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

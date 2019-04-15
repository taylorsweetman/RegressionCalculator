
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import calculator.domain.*;

public class GetTest {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Regression Calculator");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//String sql = "SELECT id, description, value FROM output_table";

		//TypedQuery<OutputStat> q = entityManager.createQuery("SELECT description FROM output_table", OutputStat.class);
		
		Integer primaryKey = 9;
		OutputStat os = entityManager.find(OutputStat.class, primaryKey);
		
		System.out.println(os.getDescription());
		
		
       
	}

}

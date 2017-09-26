package ro.deutsche.mediastore.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import ro.deutsche.mediastore.domain.Client;

@Component
public class ClientDAO {

	@PersistenceContext
	protected EntityManager em;

	public Client getSoleClient() {
		Query q = em.createQuery("from Client c");
		return (Client)q.getSingleResult();
		
	}
}

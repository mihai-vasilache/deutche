package ro.deutsche.mediastore.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Component;
import ro.deutsche.mediastore.domain.Client;

@Component
public class ClientDAO {

	@PersistenceContext
	protected EntityManager em;

	public List<Client> getSoleClient() {
		Query q = em.createQuery("select distinct c from Client c left join fetch c.rentals");
		return (List<Client>)q.getResultList();
		
	}
}

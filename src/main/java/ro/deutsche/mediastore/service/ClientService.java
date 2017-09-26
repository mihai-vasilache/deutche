package ro.deutsche.mediastore.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.deutsche.mediastore.dao.ClientDAO;
import ro.deutsche.mediastore.domain.Client;

@Service
@Transactional
public class ClientService {
	
	@Autowired
	private ClientDAO clientDAO;

	public Client getSoleClient() {
		return clientDAO.getSoleClient();
	}
}

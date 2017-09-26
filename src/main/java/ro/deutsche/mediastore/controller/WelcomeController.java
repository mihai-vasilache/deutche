package ro.deutsche.mediastore.controller;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static ro.deutsche.mediastore.domain.AgeAudiance.CHILDREN;
import ro.deutsche.mediastore.domain.Client;
import ro.deutsche.mediastore.domain.CustomerCategory;
import ro.deutsche.mediastore.domain.FrequesntReleasePoints;
import static ro.deutsche.mediastore.domain.FrequesntReleasePoints.NEW_RELEASE;
import ro.deutsche.mediastore.domain.Rental;
import ro.deutsche.mediastore.service.ClientService;

@Controller
public class WelcomeController {
	
	@Autowired
	ClientService clientService;
		
	@RequestMapping(value="/")
	public String welcome(Map<String, Object> model) {
		Client client = clientService.getSoleClient();
		String report = getCartStatement(client);
		model.put("report", report);
		return "welcome";
	}

	public String getCartStatement(Client client) {
		return "report for" + client.getName();
	}

}

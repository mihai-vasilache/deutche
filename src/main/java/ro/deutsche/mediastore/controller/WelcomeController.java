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
		int loyaltyPoints = 0;
		
		String statement = "Shopping history report for " + client.getName() + ":\n";
		for (Rental rental : client.getRentals()) {
			BigDecimal rentalPrice = new BigDecimal(0, new MathContext(2, RoundingMode.HALF_UP));;
			String rentalStatement = "";
			int loyaltyPointsBeforeCart = loyaltyPoints;
			rentalStatement += "\n\t\u2022" + rental.getPurchiseDate() + " on date " + rental.getPurchiseDate() + ": \n";
			
				int loyaltyPointsBeforeItem = loyaltyPoints;
				BigDecimal basePrice = rental.getProduct().getPrice();
				BigDecimal cartItemPrice = basePrice.multiply(rental.getQuantity());
				String daysRented = "";
				
					loyaltyPoints++;
					if (rental.getQuantity().intValue() > 1 && rental.getProduct().getRentalFrequency() == NEW_RELEASE) {
						loyaltyPoints++;
					}
					if (rental.getProduct().getRentalFrequency() == FrequesntReleasePoints.INFREQUENT_RENTAL) {
						loyaltyPoints++;
					}
					if (rental.getQuantity().intValue() > 4 && rental.getProduct().getAgeAudience() == CHILDREN) {
						loyaltyPoints = loyaltyPoints + 2;
					}
					
				
					
				
			
			if (client.getCustomerCategory() == CustomerCategory.GOLD) {
				loyaltyPoints = 0;
			}
			
			
		}
		statement += "\t\u00bb You had accumulated " + loyaltyPoints + " loyalty points.\n";
		statement += "\t\u00bb You are a " + " customer.\n";
		return statement;
	}

}

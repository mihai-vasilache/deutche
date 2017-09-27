package ro.deutsche.mediastore.service;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.deutsche.mediastore.dao.ClientDAO;
import ro.deutsche.mediastore.domain.AgeAudiance;
import static ro.deutsche.mediastore.domain.AgeAudiance.CHILDREN;
import static ro.deutsche.mediastore.domain.AgeAudiance.GENERAL_AUDIENCE;
import ro.deutsche.mediastore.domain.Client;
import ro.deutsche.mediastore.domain.CustomerCategory;
import static ro.deutsche.mediastore.domain.CustomerCategory.GOLD;
import static ro.deutsche.mediastore.domain.CustomerCategory.NEW;
import static ro.deutsche.mediastore.domain.CustomerCategory.REGULAR;
import static ro.deutsche.mediastore.domain.FrequesntReleasePoints.INFREQUENT_RENTAL;
import static ro.deutsche.mediastore.domain.FrequesntReleasePoints.NEW_RELEASE;
import static ro.deutsche.mediastore.domain.ProductType.BOOK_RENTAL_DRM;
import static ro.deutsche.mediastore.domain.ProductType.MOVIE_STREAMINIG;
import static ro.deutsche.mediastore.domain.ProductType.SONG_RENTAL_DRM;
import ro.deutsche.mediastore.domain.Rental;

@Service
@Transactional
public class ClientService {
	
	@Autowired
	private ClientDAO clientDAO;

	public static final BigDecimal ONE_HUNDRED = new BigDecimal(100).setScale(2,BigDecimal.ROUND_HALF_UP);
	
	public String getClientTxtReport() {
		String report ="";
 		List<Client> clients = clientDAO.getSoleClient();
		for(Client client : clients) {
			CustomerCategory category = CustomerCategory.NEW;
			int loyaltyPoints = 0;
			report += "Shopping history report for " + client.getName() + ":\n";
			Iterator<Rental> rentalsIt = client.getRentals().iterator();
			int idx = 0;
			while(rentalsIt.hasNext()) {
			idx++;
			Rental rental = rentalsIt.next();
				
				BigDecimal rentalPrice = BigDecimal.ONE.setScale(2, BigDecimal.ROUND_HALF_UP);
				//prețurile pe prima zi
				if(rental.getProduct().getAgeAudience() == GENERAL_AUDIENCE) {
					rentalPrice.add(rental.getProduct().getPrice().multiply(new BigDecimal(0.1)));
				}
				if(rental.getProduct().getAgeAudience() == AgeAudiance.ADULT_CONTENT) {
					rentalPrice.add(rental.getProduct().getPrice());
				}
				if(rental.getProduct().getAgeAudience() == CHILDREN) {
					rentalPrice.add(rental.getProduct().getPrice().multiply(BigDecimal.TEN).divide(ONE_HUNDRED));
				}
				
				//MULTI DAY RENTAL (pentru FREQUENT_RELEASE_POINTS)
				if(rental.getProduct().getAgeAudience() == CHILDREN) {
					if(rental.getDays() < 4) {
						rentalPrice.multiply(new BigDecimal(rental.getDays()));
					}
					int remainingDays = rental.getDays() - 3;
					rentalPrice.add(rentalPrice.multiply(new BigDecimal(0.75).multiply(new BigDecimal(remainingDays))));
				}
				if(rental.getProduct().getRentalFrequency() == NEW_RELEASE) {
					if(rental.getDays() < 1) {
						rentalPrice.add(rental.getProduct().getPrice().multiply(new BigDecimal(1.5)).multiply(new BigDecimal(rental.getDays())));
					}
				}
				if(rental.getProduct().getRentalFrequency() == INFREQUENT_RENTAL) {
					rentalPrice.add(rental.getProduct().getPrice().multiply(new BigDecimal(0.0)).multiply(new BigDecimal(rental.getDays())));
				}
				
				//reducerile la tip Produs
				if(rental.getProduct().getProductType() == MOVIE_STREAMINIG) {
					rentalPrice.subtract(rentalPrice.multiply(new BigDecimal(0.05)));
				}
				if(rental.getProduct().getProductType() == BOOK_RENTAL_DRM) {
					rentalPrice.subtract(rentalPrice.multiply(new BigDecimal(0.5)));
				}
				if(rental.getProduct().getProductType() == SONG_RENTAL_DRM) {
					rentalPrice.subtract(rentalPrice.add(BigDecimal.ZERO));
				}
				
				// REDUCERI TIP CLIENT: CUSTOMER_CATEGORY
				if(client.getCustomerCategory() == NEW) {
					rentalPrice.multiply(new BigDecimal(0.5));
				}
				if(client.getCustomerCategory() == REGULAR) {
					rentalPrice.multiply(new BigDecimal(0.1));
				}
				if(client.getCustomerCategory() == GOLD) {
					rentalPrice.multiply(new BigDecimal(0.1));
				}
				
				report += "\t" + idx + " - " + rental.getProduct().getName() + " - " + rental.getPurchiseDate() + "\n";
			}
		}
		return report;
	}
}

package ro.deutsche.mediastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication(scanBasePackages = "ro.deutsche")
@EntityScan("ro.deutsche.mediastore.domain")
@EnableAutoConfiguration(exclude=ErrorMvcAutoConfiguration.class)
@EnableTransactionManagement
public class MediaStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaStoreApplication.class, args);
	}
}

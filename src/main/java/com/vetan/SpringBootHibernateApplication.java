package com.vetan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootHibernateApplication extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(SpringBootHibernateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootHibernateApplication.class);
	}

	/*@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {

			repository.save(new Customer("Umesh", "Awasthi","email@test.com"));
			repository.save(new Customer("David", "Dobrik", "email1@test.com"));
			repository.save(new Customer("Robert", "Hickle","r.k@email.com"));
			repository.save(new Customer("Edgar", "Smith","edgar@email.com"));
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
		};
	}*/
}

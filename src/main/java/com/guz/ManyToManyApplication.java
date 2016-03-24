package com.guz;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
@EnableTransactionManagement
public class ManyToManyApplication {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyApplication.class, args);
	}

	@Bean
	public SessionFactory sessionFactory() {
		return entityManagerFactory.unwrap(SessionFactory.class);
	}
}

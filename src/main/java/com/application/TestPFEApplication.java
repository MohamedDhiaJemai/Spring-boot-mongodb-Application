package com.application;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.application.entites.Centre;
import com.application.entites.Role;
import com.application.entites.User;
import com.application.repository.CentreRepository;
import com.application.repository.RoleRepository;
import com.application.repository.UserRepository;

@SpringBootApplication
public class TestPFEApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestPFEApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CentreRepository centreRepo, RoleRepository roleRepo, UserRepository userRepo) {
		return args -> {

			User user1 = new User(null, "med", "med123", "mohamed", "ali", 97000000, 123456, "matricule1","5e37e0b3aa126e6bd5a89590","5e37e1f3aa126e6bd5a895ba");
			User user2 = new User(null, "ahmed", "ahmed123", "ahmed", "ali", 97123456, 456789, "matricule2","5e37e0b3aa126e6bd5a89591","5e37e1f3aa126e6bd5a895ba");
			User user3 = new User(null, "salah", "salah123", "salah", "ali", 97001122, 159159, "matricule3","5e37e0b3aa126e6bd5a89593","5e37e1f3aa126e6bd5a895bb");
			User user4 = new User(null, "oussema", "oussema123", "oussema", "ali", 97223344, 754168, "matricule4","5e37e0b3aa126e6bd5a89593","5e37e1f3aa126e6bd5a895bb");

			userRepo.deleteAll();
			userRepo.save(user1);
			userRepo.save(user2);
			userRepo.save(user3);
			userRepo.save(user4);

			Centre BaseKP = new Centre(null, "Base KP", "Base KP", Arrays.asList(user1, user2));
			Centre BaseBA = new Centre(null, "Base BA", "Base BA", Arrays.asList(user3, user4));

			centreRepo.deleteAll();
			centreRepo.save(BaseKP);
			centreRepo.save(BaseBA);

			Role Personnel = new Role(null, "Personnel", "Personnel", Arrays.asList(user1));
			Role Production = new Role(null, "Resp. Production", "Resp. Production", Arrays.asList(user2));
			Role paie = new Role(null, "Resp. paie", "Resp. paie", Arrays.asList());
			Role Manager = new Role(null, "Manager", "Manager", Arrays.asList(user3, user4));

			roleRepo.deleteAll();
			roleRepo.save(Personnel);
			roleRepo.save(Production);
			roleRepo.save(paie);
			roleRepo.save(Manager);

		};
	}

}

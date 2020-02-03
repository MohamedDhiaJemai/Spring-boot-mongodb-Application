package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.application.entites.User;
import com.application.repository.UserRepository;

@RestController
@RequestMapping(value = "/users", method = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST })
@CrossOrigin(origins = { "http://localhost:4200" })
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private MongoTemplate mtUser;

	@GetMapping("/all")
	@Query(value = "{}", fields = "{'objectContentAsJson':0}")
	public Iterable<User> getall() {
		return (userRepo.findAll());
	}

	@PostMapping(value = "/add" )
	public User save(@RequestBody User user) {
		return userRepo.save(user);
	}

	@DeleteMapping("/delete/{id}")
	public List<User> delete(@PathVariable("id") String id) {
		userRepo.deleteById(id);
		return userRepo.findAll();
	}

	@PutMapping("/update/{id}")
	public User update(@PathVariable("id") String id, @RequestBody User user) {
		user.setId(id);
		return userRepo.save(user);
	}

	@GetMapping("/matricule/{matricule}")
	public List<User> findByMatricule(@PathVariable("matricule") String matricule) {
		return (userRepo.findByMatricule(matricule));
	}

	/* Find By Nom */
	@GetMapping("/nom/{nom}")
	public List<User> findByNom(@PathVariable("nom") String nom) {
		return (userRepo.findByNom(nom));
	}

	/* Find By Login */
	@GetMapping("/login/{login}")
	public User findByLogin(@PathVariable("login") String login) {
		return userRepo.findByLogin(login);
	}

	/* Find By Prenom */
	@GetMapping("/prenom/{prenom}")
	public List<User> findByPrenom(@PathVariable("prenom") String prenom) {
		return (userRepo.findByPrenom(prenom));
	}

	@GetMapping("/userCentre/{idCentre}")
	List<User> findByCentre(@PathVariable("idCentre") String idCentre) {
		return (userRepo.findByCentre(idCentre));
	}

	@GetMapping("/userRole/{idRole}")
	List<User> findByRole(@PathVariable("idRole") String idRole) {
		return (userRepo.findByRole(idRole));
	}

}

package com.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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

import com.application.entites.Centre;
import com.application.repository.CentreRepository;


@RestController	
@RequestMapping(value = "/centres", method = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST })
@CrossOrigin(origins= {"http://localhost:4200"})
public class CentreController {
	
	@Autowired
	private CentreRepository centreRepo;
	
	@Autowired
	private MongoTemplate mtCentre;
	
//	@Autowired
//	private MongoTemplate mtCenter;
	
	
	
	/* Add Center */
	@PostMapping(value = "/add")
	public Centre save(@RequestBody Centre centre) {
		return centreRepo.save(centre);
	}
	
	/* Get All */
	@GetMapping("/all")
	public Iterable<Centre> getall() {
		return centreRepo.findAll();
	}
	
	/* Delete Centre By Id */
	@DeleteMapping("/delete/{id}")
	public List<Centre> delete(@PathVariable("id") String id) {
		centreRepo.deleteById(id);
		return centreRepo.findAll();
	}
	
	/* Update Role */
	@PutMapping("/update/{id}")
	public Centre update(@PathVariable("id") String id, @RequestBody Centre centre) {
		centre.setId(id);
		return centreRepo.save(centre);
	}
	
	/* Find By reference */
	@GetMapping("/reference/{reference}")
	public Centre findByReference(@PathVariable("reference") String reference) {
		return (centreRepo.findByReference(reference));
	}
	
	/* Find By Role */
	@GetMapping("/libelle/{libelle}")
	public Centre findByLibelle(@PathVariable("libelle") String libelle) {
		return (centreRepo.findByLibelle(libelle));
	}
}

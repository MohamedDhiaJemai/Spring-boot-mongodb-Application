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

import com.application.entites.Role;
import com.application.repository.RoleRepository;

@RestController
@RequestMapping(value = "/roles", method = { RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST })
@CrossOrigin(origins = { "http://localhost:4200" })
public class RoleController {

	@Autowired
	private RoleRepository roleRepo;
	@Autowired
	private MongoTemplate mtRole;

//	@Autowired
//	private MongoTemplate mtRole;

	/* Add User */
	@PostMapping(value = "/add")
	public Role save(@RequestBody Role role) {
		return roleRepo.save(role);
	}

	/* Get All */
	@GetMapping("/all")
	public Iterable<Role> getall() {
		return roleRepo.findAll();
	}

	/* Delete User By Id */
	@DeleteMapping("/delete/{id}")
	public List<Role> delete(@PathVariable("id") String id) {
		roleRepo.deleteById(id);
		return roleRepo.findAll();
	}

	/* Update Role */
	@PutMapping("/update/{id}")
	public Role update(@PathVariable("id") String id, @RequestBody Role role) {
		role.setId(id);
		return roleRepo.save(role);
	}

	/* Find By Description */
	@GetMapping("/descripton/{description}")
	public Role findByDescription(@PathVariable("description") String description) {
		return (roleRepo.findByDescription(description));
	}

	/* Find By Role */
	@GetMapping("/role/{role}")
	public Role findByRole(@PathVariable("role") String role) {
		return (roleRepo.findByRole(role));
	}

}
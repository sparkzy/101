package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.Status;
import com.revature.services.ServiceInterface;

@RestController
@RequestMapping("status")
@CrossOrigin(origins = "http://localhost:4200")
public class StatusController {
	@Autowired
	private ServiceInterface<Status> statService;
	
	@PostMapping
	public Status createStatus(@RequestBody Status s) {
		return statService.save(s);
	}

	@GetMapping
	public List<Status> findAll() {
		return statService.findAll();
	}
	
	@GetMapping("id/{id}")
	public Status findById(@PathVariable int id) {
		return statService.findById(id);
	}
	@PutMapping
	public void updateStatus(@RequestBody Status stat) {
		statService.update(stat);
	}
	@DeleteMapping("id/{id}")
	public void deleteStatus(@PathVariable int id) {
		statService.delete(id);
	}
	

}

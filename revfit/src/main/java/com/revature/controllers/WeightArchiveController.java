package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.WeightArchive;
import com.revature.services.WeightArchiveService;

@CrossOrigin(maxAge = 3600, origins = "http://localhost:4200")
@RestController
public class WeightArchiveController {

	@Autowired
	WeightArchiveService ws;
	
	@GetMapping(value = "/weightArchive") 
	public WeightArchive getWeightArchive(@PathVariable int id){
		return ws.getWeightArchive(id);
	}
	
	@PutMapping(value = "/weightArchive/{id}")
	public WeightArchive updateWeightArchive(@RequestBody WeightArchive change, @PathVariable int id) {
		change.setId(id);
		return ws.updateWeightArchive(change);
	}
	
	@DeleteMapping(value = "/weightArchive/{id}")
	public boolean deleteWeightArchive(@RequestBody WeightArchive wa, @PathVariable int id) {
		wa.setId(id);
		return ws.deleteWeightArchive(wa);
	}
	
	
}

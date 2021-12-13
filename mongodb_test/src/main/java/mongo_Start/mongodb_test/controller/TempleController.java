package mongo_Start.mongodb_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mongo_Start.mongodb_test.modules.Temple;
import mongo_Start.mongodb_test.service.TempleService;

@RestController
public class TempleController {
	@Autowired
	TempleService templeservice;
	
	@PostMapping("/Temple/add")
	private  Temple saveTemple(@RequestBody Temple temple)
	{
		return templeservice.saveTemple(temple);
		
		
	}
	
	@GetMapping("/Temple/Temples")
	private List<Temple> getAllTempleDetails()
	{
		return templeservice.getAllTempleDetails();
	}
	
	@GetMapping("/Temple/find/{id}")
	private Temple getTempleById(@PathVariable("id") int id)
	{
		return templeservice.getTempleById(id);
	}

	@PutMapping("/Temple/update/{id}")
	private  Temple updateTempleById(@RequestBody Temple temple, @PathVariable("id") int id) {
		
		return templeservice.updateTempleById(temple, id);
	}
	
	@DeleteMapping("/Temple/delete/{id}")
	private  ResponseEntity<String> deleteTempleById(@PathVariable("id") int id)
	{
		templeservice.deleteTempleById(id);
		return new ResponseEntity<String>("Temple Profile Deleted Successfully",HttpStatus.OK);
	}
}

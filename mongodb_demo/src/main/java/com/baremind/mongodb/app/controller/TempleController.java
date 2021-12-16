package com.baremind.mongodb.app.controller;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baremind.mongodb.app.modules.Temple;
import com.baremind.mongodb.app.service.TempleService;


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
	
	@GetMapping("/search/Temple/date")
	private Page<Temple> getBycreatedDate(@RequestParam(name = "dateTime",required = false) 
	 @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	                                         Date createdDate, 
	                                       @Param("page")int page,
	                                       @Param("size") int size) {
		
		return templeservice.getBycreatedDate(createdDate, page, size);
	}
}

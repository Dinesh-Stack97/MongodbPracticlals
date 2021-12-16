package com.baremind.mongodb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baremind.mongodb.app.modules.Donars;
import com.baremind.mongodb.app.service.DonarService;

@RestController

public class DonarController {
	
	@Autowired
	private DonarService donarService;
	
	@PostMapping("/temple/{id}/donar")
	private ResponseEntity<Donars> saveDonar(String donationId, Donars donar)
	{
		return new ResponseEntity<Donars>(donarService.saveDonar(donationId, donar),HttpStatus.OK);
	}

	@GetMapping("/temple/{id}/donars")
	private List<Donars> getAllDonarsDetails(String donationId) {
		return donarService.getAllDonarsDetails(donationId);
	}
	
	@GetMapping("/temple/{id}/donations/{id}")
	private Donars getDonarById(int id) {
		return donarService.getDonarById(id);
	}
	
	@PostMapping("/Donar/{id}")
	private  Donars updateDonarById(Donars donar, int id) {
		return donarService.updateDonarById(donar, id);
	}
	
	@DeleteMapping("/Donar/{id}")
	private ResponseEntity<String> deleteDonarById(int id){
		
		return new ResponseEntity<String>("Donar Deleted",HttpStatus.OK);
	}
	
	@GetMapping("/Pageable")
	private Page<Donars> retriveDonarwithPaging(@Param(value="page") int page,@Param(value="size") int size)
	{
		return donarService.retriveretriveDonarwithPaging(page, size);
	}
	//this returns donar in list
	@GetMapping("/Pageable/list")
	private  List<Donars> retriveDonarListwithPaging(@Param(value="page") int page,@Param(value="size") int size){
		
		return donarService.retriveDonarListwithPaging(page, size);
	}
	
	@GetMapping("/Donar/Search/id/{id}/{page}/{size}")
	private Slice<Donars> getAllByIdGreater(@PathVariable("id") int donationId,@PathVariable("page") int page,@PathVariable("size") int size) {
		return donarService.getAllByIdGreater(donationId, page, size);
	}
}

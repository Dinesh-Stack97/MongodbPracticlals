package com.baremind.mongodb.app.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baremind.mongodb.app.modules.Donars;
import com.baremind.mongodb.app.modules.Donations;
import com.baremind.mongodb.app.modules.Temple;
import com.baremind.mongodb.app.service.DonationService;

import io.swagger.models.Response;



@RestController

public class DonationController {
	
	@Autowired
	private DonationService donationService;
	
	@PostMapping("/temple/{id}/donations")
    private Donations  saveDonations(@PathVariable("id") String templeId,@RequestBody Donations donation)
    {
		return donationService.saveDonations(templeId, donation);
    }
	
	@GetMapping("/temple/{id}/donations")
	private  List<Donations> getAllDonationsDetails(@PathVariable("id") String templeId) 
	{
		return donationService.getAllDonationsDetails(templeId);
	}
	
	
	@GetMapping("/Donations/Page")
	private  Page<Donations> getAllDonations(@Param(value="page") int page,@Param(value="size") int size) {
		return donationService.getAllDonations(page, size);
	}
	
	@GetMapping("/Donations/search/id/{id}/{page}/{size}")
   private	Slice<Donations> getAllById(@PathVariable("id") int donationId,@PathVariable("page") int page,@PathVariable("size") int size) 
		{ 
	   return donationService.getAllById(donationId, page, size);
   }
	
	@GetMapping("/Donations/search/Cash")
	private Slice<Donations> getAllBycash(@Param("cash") double cash,@Param("page") int page,@Param("size") int size)
	{
		return donationService.getAllBycash(cash, page, size);
	}
	
	@GetMapping("/Donations/Temple/id/{id}/{page}/{size}")
	private  Slice<Donations> getAllBytempleId(@PathVariable("id") String templeId,@PathVariable("page") int page ,@PathVariable("size") int size)
	{
		return donationService.getAllBytempleId(templeId, page, size);
	}
	
	@GetMapping("/Donations/type/{type}")
	private Slice<Donations> getAllBytype(@PathVariable("type") String type,@Param(value="page") int page,@Param(value="size") int size)
	{
		return donationService.getAllBytype(type, page, size);
	}
	
	@GetMapping("/Donations/subType/{subtype}")
	private  Slice<Donations> getAllBysubtype(@PathVariable("subtype")String subtype,@Param(value="page") int page,@Param(value="size") int size) {
		return donationService.getAllBysubtype(subtype, page, size);
	}
	
	@GetMapping("/search/donations/DonarName/{donar}")
	private Slice<Donations> getAllBydonarName(@PathVariable("donar")String donarName,@Param(value="page") int page,@Param(value="size") int size)
	{
		return donationService.getAllBydonarName(donarName, page, size);
				
	}
	
	@GetMapping("/search/donations/type/subtype/{type}/{subtype}")
	private Slice<Donations> getAllBytypeAndsubtype(@PathVariable("type")String type,
			                                         @PathVariable("subtype")String subtype,
			                                         @Param(value="page") int page,
			                                         @Param(value="size")int size) {
		
		return donationService.getAllBytypeAndsubtype(type, subtype, page, size);
	}
	
	@GetMapping("/search/between/cash")
private Page<Donations> getDonationsBycashBetween(@Param(value="mincash")double mincash, 
		                                           @Param(value="maxcash") double maxcash, 
		                                           @Param(value="page") int page, 
		                                           @Param(value="size") int size) {
		
	return donationService.getDonationsBycashBetween(mincash, maxcash, page, size);
}
	@GetMapping("/search/cash/{cash}")
	private  List<Page<Donations>> SearchBycash(@PathVariable("cash") double cash, 
			                                    @Param(value="page") int page,@Param(value="size") int size) {
		return donationService.SearchBycash(cash, page, size);
	}
	
	@GetMapping("/search/cash/greater/{cash}")
	private Page<Donations> getBycashGreaterthan(@PathVariable("cash") double cash, 
			                                     @Param(value="page") int page,
			                                     @Param(value="size") int size) {
		
		return donationService.getBycashGreaterthan(cash, page, size);
	}
	
	@GetMapping("/search/donations/date")
	private Page<Donations> getBycreatedDate(@RequestParam(name = "dateTime") 
	                                      @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") 
	                                               LocalDate createdDate,
			                                  @Param(value="page") int page,
			                                  @Param(value="size") int size)
	
    {
		
		return donationService.getBycreatedDate(createdDate, page, size);
	}
	
}

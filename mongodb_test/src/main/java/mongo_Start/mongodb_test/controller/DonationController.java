package mongo_Start.mongodb_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mongo_Start.mongodb_test.modules.Donations;
import mongo_Start.mongodb_test.service.DonationService;

@RestController
@RequestMapping("Donations")
public class DonationController {
	
	@Autowired
	private DonationService donationService;
	
	@PostMapping("/donation")
	private Donations saveDonations(Donations Donation) 
	{
		return donationService.saveDonations(Donation);
	}
	
	@GetMapping("/donations")
	private  List<Donations> getAllDonationsDetails() 
	{
		return donationService.getAllDonationsDetails();
	}

}

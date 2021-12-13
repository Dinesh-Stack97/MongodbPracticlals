package mongo_Start.mongodb_test.service;

import java.util.List;

import mongo_Start.mongodb_test.modules.Donations;
import mongo_Start.mongodb_test.modules.Temple;

public interface DonationService {
	
	Donations saveDonations(Donations Donation);
	
	Donations getDonationById(int id);
	Donations updateDonationById(Temple temple, int id);
	void deletedonationById(int id);
	List<Donations> getAllDonationsDetails();

}

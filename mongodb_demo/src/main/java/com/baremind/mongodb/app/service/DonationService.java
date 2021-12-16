package com.baremind.mongodb.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.query.Param;

import com.baremind.mongodb.app.modules.Donations;
import com.baremind.mongodb.app.modules.Temple;

import io.swagger.models.Response;


public interface DonationService {
	
	Donations saveDonations(String templeId ,Donations Donation);
	
	Donations getDonationById(int id);
	Donations updateDonationById(Donations donation, int id);
	void deletedonationById(int id);
	List<Donations> getAllDonationsDetails(String templeId);

	Page<Donations> getAllDonations(int page, int size);
	Slice<Donations> getAllById(int donationId, int page, int size);
	Slice<Donations> getAllBycash(double cash, int page, int size);
	Slice<Donations> getAllBytempleId(String templeId, int page, int size);
	
	Page<Donations> getAllBytype(String type, int page,int size);
	Slice<Donations> getAllBysubtype(String subtype, int page, int size);
	Slice<Donations> getAllBydonarName(String donarName, int page, int size);
	
	Slice<Donations> getAllBytypeAndsubtype(String type,String subtype, int page, int size);
	
	Page<Donations> getDonationsBycashBetween(double mincash, double maxcash,  int page, int size);
	
	List<Page<Donations>> SearchBycash(double cash,int page, int size);
	
	Page<Donations> getBycashGreaterthan(double cash, int size, int page);
	


	Page<Donations> getBycreatedDate(LocalDate createdDate, int page, int size);

	
	
	
}

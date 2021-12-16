package com.baremind.mongodb.app.service.impl;


import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.baremind.mongodb.app.Exception.Spring_Boot_Apk_Exception;
import com.baremind.mongodb.app.modules.Donations;
import com.baremind.mongodb.app.modules.Temple;
import com.baremind.mongodb.app.repository.DonationRepository;
import com.baremind.mongodb.app.repository.TempleRepository;
import com.baremind.mongodb.app.service.DonationService;

import io.swagger.models.Response;


@Service
public class DonationServiceimpl implements DonationService {

	@Autowired
	private DonationRepository donationRepository;

	
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Donations saveDonations(String templeId, Donations donation) {

		// donationRepository.findOne(templeId);
		return donationRepository.save(donation);

	}

	@Override
	public List<Donations> getAllDonationsDetails(String templeId) {
		// TODO Auto-generated method stub
		// donationRepository.findOne(templeId);
		return donationRepository.findAllBytempleId(templeId);

	}

	@Override
	public Donations getDonationById(int id) {
		// TODO Auto-generated method stub
		return donationRepository.findById(id).orElseThrow(() -> new Spring_Boot_Apk_Exception("Donation", "id", id));
	}

	@Override
	public Donations updateDonationById(Donations donation, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletedonationById(int id) {
		// TODO Auto-generated method stub
		donationRepository.deleteById(id);

	}

	@Override
	public  Page<Donations> getAllDonations(int page, int size) {
		// TODO Auto-generated method stub
		Pageable RequestedPage = PageRequest.of(page, size);
		Page<Donations> donations = donationRepository.findAll(RequestedPage);
		donations.getContent();
		donations.getNumber();
	//	donations.getNumberOfElements();
	//	donations.getTotalElements();
		donations.getSize();
		donations.getTotalPages();
		return donations;
	}

	@Override
	public Slice<Donations> getAllById(int id, int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		Slice<Donations> donations = donationRepository.findAllById(id, requestedPage);
		donations.getContent();
		donations.getNumber();
		donations.getNumberOfElements();
	//	donations.getNumberOfElements();
		donations.getSize();
	//	((Page<Donations>) donations).getTotalPages();
	
		return donations;

	}

	@Override
	public Slice<Donations> getAllBycash(double cash, int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		Slice<Donations> donations = donationRepository.findAllBycash(cash, requestedPage);
		donations.getContent();
		donations.getNumber();
		donations.getNumberOfElements();
	//	((Page<Donations>) donations).getTotalElements();
		donations.getSize();
	//	((Page<Donations>) donations).getTotalPages();
		return donations;
	}

	@Override
	public Slice<Donations> getAllBytempleId(String templeId, int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		Slice<Donations> donations = donationRepository.findAllBytempleId(templeId, requestedPage);
		donations.getContent();
		donations.getNumber();
		donations.getNumberOfElements();
	//	((Page<Donations>) donations).getTotalElements();
		donations.getSize();
		//((Page<Donations>) donations).getTotalPages();
		return donations;
	}

	@Override
	public Page<Donations> getAllBytype(String type, int page, int size) {
		// TODO Auto-generated method stub
		Pageable RequestedPage = PageRequest.of(page, size);
		//Slice<Donations> donations = donationRepository.findAllBytype(type, RequestedPage);
		
		
		Page<Donations> donations =  donationRepository.findAllBytype(type, RequestedPage);
		donations.getContent();
		donations.getNumber();
		donations.getNumberOfElements();
		//((Page<Donations>) donations).getTotalElements();
		donations.getSize();
	//	((Page<Donations>) donations).getTotalPages();
		return donations;
	
		
		
	}

	@Override
	public Slice<Donations> getAllBysubtype(String subtype, int page, int size) {
		// TODO Auto-generated method stub
		Pageable RequestedPage = PageRequest.of(page, size);
		Slice<Donations> donations = donationRepository.findAllBysubtype(subtype, RequestedPage);
		donations.getContent();
		donations.getNumber();
		donations.getNumberOfElements();
		//((Page<Donations>) donations).getTotalElements();
		donations.getSize();
	//	((Page<Donations>) donations).getTotalPages();
		return donations;
	}

	@Override
	public Slice<Donations> getAllBydonarName(String donarName, int page, int size) {
		// TODO Auto-generated method stub
		Pageable RequestedPage = PageRequest.of(page, size);
		Slice<Donations> donations = donationRepository.findAllBydonarName(donarName, RequestedPage);
		donations.getContent();
		donations.getNumber();
		donations.getNumberOfElements();
		((Page<Donations>) donations).getTotalElements();
		donations.getSize();
		((Page<Donations>) donations).getTotalPages();
		return donations;
	}

	@Override
	public Slice<Donations> getAllBytypeAndsubtype(String type, String subtype, int page, int size) {
		// TODO Auto-generated method stub
		Pageable RequestedPage = PageRequest.of(page, size);
		Slice<Donations> donations = donationRepository.findAllBytypeAndsubtype(type, subtype, RequestedPage);
		donations.getContent();
		donations.getNumber();
		donations.getNumberOfElements();
	//	((Page<Donations>) donations).getTotalElements();
		donations.getSize();
		//((Page<Donations>) donations).getTotalPages();
		return donations;
		
	}

	@Override
	public Page<Donations> getDonationsBycashBetween(double mincash, double maxcash, int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		Page<Donations> donations = donationRepository.findDonationsBycashBetween(mincash, maxcash, requestedPage);
		donations.getContent();
		donations.getNumberOfElements();
		donations.getSize();
		donations.getTotalPages();
		donations.getTotalElements();
		return donations;
		
	}

	@Override
	public List<Page<Donations>> SearchBycash(double cash, int page, int size) {
		
		// TODO Auto-generated method stub
		//MatchOperation
		MatchOperation matchOperation = Aggregation.match(new Criteria("cash").is(cash));
		//sort
		SortOperation sortOperation = Aggregation.sort(Sort.by(Sort.Direction.DESC,"cassh"));
		//Aggregation
		Aggregation aggregation = Aggregation.newAggregation(matchOperation,sortOperation);
	
		
	AggregationResults output =  mongoTemplate.aggregate(aggregation, "Donations",Donations.class);
		return output.getMappedResults();
	}

	@Override
	public Page<Donations> getBycashGreaterthan(double cash, int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size); 
		Page<Donations> donation = donationRepository.findBycashGreaterthan(cash,requestedPage);
		return donation;
	}


	public Page<Donations> getBycreatedDate(LocalDate createdDate, int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		Page<Donations> donation = donationRepository.findBycreatedDate(createdDate, requestedPage);
		
		return donation;
		
	}

	
	

	

}

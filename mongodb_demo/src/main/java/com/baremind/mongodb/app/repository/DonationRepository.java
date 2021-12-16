package com.baremind.mongodb.app.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.baremind.mongodb.app.modules.Donars;
import com.baremind.mongodb.app.modules.Donations;


public interface DonationRepository extends MongoRepository<Donations, Integer>{


	//List<Donations> findOne(String templeId);
	Slice<Donations> findAllById(int id, Pageable pageable);
	Slice<Donations> findAllBycash(double cash, Pageable pageable);
	Slice<Donations> findAllBytempleId(String templeId, Pageable pageable);
	//Slice<Donars> findAllByIdGreater(int donationId, PageRequest pageable);
	Page<Donations> findAll(Pageable pageable);
	
	List<Donations> findAllBytempleId(String templeId);
	
	Page<Donations> findAllBytype(String type, Pageable pageable);
	Slice<Donations> findAllBysubtype(String subtype, Pageable pageable);
	Slice<Donations> findAllBydonarName(String donarName, Pageable pageable);
	
	//@Query("{'type': ?0,'subtype': ?1 }")
	@Query("{'type':{'$regex': '?0', '$options':'1'},'subtype':{'$regex':'?1', '$options':'1'} }")
	Slice<Donations> findAllBytypeAndsubtype(String type,String subtype, Pageable pageable);
	
	
	Slice<Donations> findAllByTypeContainingIgnoreCase(String type, Pageable pageable);
	
	@Query("{'cash':{'$gt': ?0, '$lt':?1} }")
	Page<Donations> findDonationsBycashBetween(double mincash, double maxcash, Pageable pageable);
	
	//Agregation
	List<Page<Donations>> findBycash(double cash,Pageable pageable);
	
	@Query("{'cash':{'$gt': ?0} }")
	Page<Donations>findBycashGreaterthan(double cash, Pageable pageable);
	@Query("{'createdDate': ?0}")
	Page<Donations>findBycreatedDate(LocalDate createdDate, Pageable pageable);
	
	
	
	
}

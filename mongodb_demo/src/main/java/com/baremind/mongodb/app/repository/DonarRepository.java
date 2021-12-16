package com.baremind.mongodb.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.baremind.mongodb.app.modules.Donars;


public interface DonarRepository extends MongoRepository<Donars, Integer>{

	Slice<Donars> findAllById(int donationId, PageRequest pageable);
	//Slice<Donars> findAllByIdGreater(int donationId, PageRequest pageable);
	Page<Donars> findAll(Pageable pageable);

	//void findOne(String donationId);
	
	

}

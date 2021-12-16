package com.baremind.mongodb.app.repository;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.baremind.mongodb.app.modules.Donations;
import com.baremind.mongodb.app.modules.Temple;


public interface TempleRepository extends MongoRepository<Temple, Integer>{

	//Optional<Donations> findOne(String id);
	
	Page<Temple>findBycreatedDate(Date createdDate, Pageable pageable);

}

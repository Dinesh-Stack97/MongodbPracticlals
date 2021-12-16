package com.baremind.mongodb.app.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.baremind.mongodb.app.modules.Temple;


public interface TempleService {
	
	Temple saveTemple(Temple temple);
	List<Temple> getAllTempleDetails();
	Temple getTempleById(int id);
	Temple updateTempleById(Temple temple, int id);
	void deleteTempleById(int id);
	
	Page<Temple> getBycreatedDate(Date createdDate, int page, int size);

}

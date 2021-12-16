package com.baremind.mongodb.app.service.impl;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.baremind.mongodb.app.Exception.Spring_Boot_Apk_Exception;
import com.baremind.mongodb.app.modules.Temple;
import com.baremind.mongodb.app.repository.TempleRepository;
import com.baremind.mongodb.app.service.TempleService;


@Service
public class TempleServiceimpl implements TempleService{
	@Autowired
	private TempleRepository templeRepository;

	@Override
	public Temple saveTemple(Temple temple) {
		// TODO Auto-generated method stub
		return templeRepository.save(temple);
	}

	@Override
	public List<Temple> getAllTempleDetails() {
		// TODO Auto-generated method stub
		return templeRepository.findAll();
	}

	@Override
	public Temple getTempleById(int id) {
		// TODO Auto-generated method stub
		return templeRepository.findById((int) id).orElseThrow(() -> new Spring_Boot_Apk_Exception("TempleProfile", "id", id));
	
	}

	

	@Override
	public void deleteTempleById(int id) {
		templeRepository.deleteById(id);
		
	}

	@Override
	public Temple updateTempleById(Temple temple, int id) {
		// TODO Auto-generated method stub
		Temple existingTemple = new Temple();
		existingTemple.setTempleName(temple.getTempleName());
		existingTemple.setPriestName(temple.getPriestName());
		existingTemple.setPhoneNumber(temple.getPhoneNumber());
		existingTemple.setEmail(temple.getEmail());
		existingTemple.setNo_of_Halls(temple.getNo_of_Halls());
		
		return existingTemple;
	}

	@Override
	public Page<Temple> getBycreatedDate(Date createdDate, int page, int size) {
		// TODO Auto-generated method stub
		Pageable RequestedPage = PageRequest.of(page, size);
		Page<Temple> temple = templeRepository.findBycreatedDate(createdDate, RequestedPage);
		return temple;
	}

}

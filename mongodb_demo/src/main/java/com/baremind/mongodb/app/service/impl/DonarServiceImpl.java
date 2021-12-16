package com.baremind.mongodb.app.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import com.baremind.mongodb.app.Exception.Spring_Boot_Apk_Exception;
import com.baremind.mongodb.app.modules.Donars;
import com.baremind.mongodb.app.repository.DonarRepository;
import com.baremind.mongodb.app.service.DonarService;


@Service
public class DonarServiceImpl implements DonarService{
	
	@Autowired
	private DonarRepository donarRepository;

	
	public Donars saveDonar(String donationId, Donars donar) {
		// TODO Auto-generated method stub
		   //  donarRepository.findOne(donationId);
		       return donarRepository.save(donar);
	}


	public List<Donars> getAllDonarsDetails(String donationId) {
		// TODO Auto-generated method stub
		//donarRepository.findOne(donationId);
		return donarRepository.findAll();
	}

	@Override
	public Donars getDonarById(int id) {
		// TODO Auto-generated method stub
		return donarRepository.findById((int) id).orElseThrow(() -> new Spring_Boot_Apk_Exception("DonarProfile", "id", id));
	}

	@Override
	public Donars updateDonarById(Donars donar, int id) {
		// TODO Auto-generated method stub donarRepository.findById((int) id).orElseThrow(() -> new Spring_Boot_Apk_Exception("DonarProfile", "id", id));
	
		
		Donars ExistingDonar = new Donars();
		ExistingDonar.setDonarName(donar.getDonarName());
		ExistingDonar.setDonationType(donar.getDonationType());
		ExistingDonar.setDesignation(donar.getDesignation());
		ExistingDonar.setLocality(donar.getLocality());
		ExistingDonar.setPhoneNumber(donar.getPhoneNumber());
		ExistingDonar.setEmail(donar.getEmail());
		
		return ExistingDonar;
	}

	@Override
	public void deleteDonarById(int id) {
		// TODO Auto-generated method stub
		 donarRepository.findById((int) id).orElseThrow(() -> new Spring_Boot_Apk_Exception("DonarProfile", "id", id));
			
		donarRepository.deleteById(id);
	}


	@Override
	public Page<Donars> retriveretriveDonarwithPaging(int page, int size) {
		// TODO Auto-generated method stub
		Pageable requestedPage = PageRequest.of(page, size);
		Page<Donars> donars = donarRepository.findAll(requestedPage);
		return donars;
	}


	@Override
	public List<Donars> retriveDonarListwithPaging(int page, int size) {
		// TODO Auto-generated method stub
		
		Pageable requestedPage = PageRequest.of(page, size);
		Page<Donars> donars = donarRepository.findAll(requestedPage);
		return donars.toList();
	}


	@Override
	public Slice<Donars> getAllByIdGreater(int donationId, int page, int size) {
		// TODO Auto-generated method stub
		PageRequest requestedPage = PageRequest.of(page, size);
		Slice<Donars> donars = donarRepository.findAllById(donationId, requestedPage);
		return donars;
	}


//	@Override
//	public Donars getDonarById(int id, int templeId) {
//		// TODO Auto-generated method stub
//		donarRepository.findById(id,templeId);
//		return null;
//	}
	
	

}

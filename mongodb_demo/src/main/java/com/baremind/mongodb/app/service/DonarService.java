package com.baremind.mongodb.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.baremind.mongodb.app.modules.Donars;
import com.baremind.mongodb.app.modules.Donations;

public interface DonarService {

	Donars saveDonar(String donationId, Donars donar);

	List<Donars> getAllDonarsDetails(String donationId);

	Donars getDonarById(int id);

	Donars updateDonarById(Donars donar, int id);

	void deleteDonarById(int id);
	// Donars getDonarById(int id, int templeId);

	Slice<Donars> getAllByIdGreater(int donationId, int page, int size);

	List<Donars> retriveDonarListwithPaging(int page, int size);

	Page<Donars> retriveretriveDonarwithPaging(int page, int size);
	
	
}

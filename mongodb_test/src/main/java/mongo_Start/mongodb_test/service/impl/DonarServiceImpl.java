package mongo_Start.mongodb_test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mongo_Start.mongodb_test.Exception.Spring_Boot_Apk_Exception;
import mongo_Start.mongodb_test.modules.Donars;
import mongo_Start.mongodb_test.repository.DonarRepository;
import mongo_Start.mongodb_test.service.DonarService;

@Service
public class DonarServiceImpl implements DonarService{
	
	@Autowired
	private DonarRepository donarRepository;

	@Override
	public Donars saveDonar(Donars donar) {
		// TODO Auto-generated method stub
		return donarRepository.save(donar);
	}

	@Override
	public List<Donars> getAllDonarsDetails() {
		// TODO Auto-generated method stub
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
	
	

}

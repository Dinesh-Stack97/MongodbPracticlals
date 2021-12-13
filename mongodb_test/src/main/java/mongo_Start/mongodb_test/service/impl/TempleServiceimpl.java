package mongo_Start.mongodb_test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mongo_Start.mongodb_test.Exception.Spring_Boot_Apk_Exception;
import mongo_Start.mongodb_test.modules.Temple;
import mongo_Start.mongodb_test.repository.TempleRepository;
import mongo_Start.mongodb_test.service.TempleService;

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

}

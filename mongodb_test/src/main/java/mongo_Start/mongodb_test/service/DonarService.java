package mongo_Start.mongodb_test.service;

import java.util.List;

import mongo_Start.mongodb_test.modules.Donars;

public interface DonarService {
	
	Donars saveDonar(Donars donar);
	List<Donars> getAllDonarsDetails();
	Donars getDonarById(int id);
	Donars updateDonarById(Donars donar, int id);
	void deleteDonarById(int id);

}

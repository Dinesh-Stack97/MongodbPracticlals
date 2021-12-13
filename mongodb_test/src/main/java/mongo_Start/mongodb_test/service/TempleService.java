package mongo_Start.mongodb_test.service;

import java.util.List;

import mongo_Start.mongodb_test.modules.Temple;

public interface TempleService {
	
	Temple saveTemple(Temple temple);
	List<Temple> getAllTempleDetails();
	Temple getTempleById(int id);
	Temple updateTempleById(Temple temple, int id);
	void deleteTempleById(int id);

}

package mongo_Start.mongodb_test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mongo_Start.mongodb_test.modules.Temple;

public interface TempleRepository extends MongoRepository<Temple, Integer>{

}

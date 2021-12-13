package mongo_Start.mongodb_test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mongo_Start.mongodb_test.modules.Donars;

public interface DonarRepository extends MongoRepository<Donars, Integer>{

}

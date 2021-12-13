package mongo_Start.mongodb_test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import mongo_Start.mongodb_test.modules.Donations;

public interface DonationRepository extends MongoRepository<Donations, Integer>{

}

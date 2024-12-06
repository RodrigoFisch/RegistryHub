package com.adrtc.RegistryHub.repository;

import com.adrtc.RegistryHub.domain.RegisterPerson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterPersonRepository extends MongoRepository<RegisterPerson, String> {

}

package com.adrtc.RegistryHub.repository;

import com.adrtc.RegistryHub.domain.RegisterPerson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterPersonRepository extends MongoRepository<RegisterPerson, String> {

    Optional<RegisterPerson> findByCpf(String cpf);
}

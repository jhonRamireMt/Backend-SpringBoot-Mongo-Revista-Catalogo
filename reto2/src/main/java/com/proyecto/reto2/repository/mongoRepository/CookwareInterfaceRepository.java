package com.proyecto.reto2.repository.mongoRepository;

import com.proyecto.reto2.model.Cookware;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CookwareInterfaceRepository extends MongoRepository<Cookware,String> {

    Optional<Cookware> findByReference(String reference);
}

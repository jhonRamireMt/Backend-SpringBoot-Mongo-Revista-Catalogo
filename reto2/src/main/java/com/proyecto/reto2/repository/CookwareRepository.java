package com.proyecto.reto2.repository;

import com.proyecto.reto2.model.Cookware;
import com.proyecto.reto2.repository.mongoRepository.CookwareInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CookwareRepository {

    @Autowired
    private CookwareInterfaceRepository cookwareInterfaceRepository;

    public Cookware saveProducto(Cookware producto){
        return (Cookware) cookwareInterfaceRepository.save(producto);
    }

    public List<Cookware> getAllProducts(){
        return (List<Cookware>) cookwareInterfaceRepository.findAll();
    }

    public void deleteProduct(String reference){
        cookwareInterfaceRepository.deleteById(reference);
    }

    public Optional<Cookware> findByReference(String reference){
        return cookwareInterfaceRepository.findByReference(reference);
    }
}

package com.proyecto.reto2.service;

import com.proyecto.reto2.model.Cookware;
import com.proyecto.reto2.repository.CookwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CookwareService {

    @Autowired
    private CookwareRepository cookwareRepository;

    /* METODO PARA GUARDAR UN PRODUCTO VALIDADO POR REFERENCIA*/
    public Cookware saveProduct(Cookware cookware){
        Optional<Cookware> validarReferencia = cookwareRepository.findByReference(cookware.getReference());
        if(!validarReferencia.isPresent()){
            cookwareRepository.saveProducto(cookware);
        }
        return null;
    }

    /* MOSTRAR PRODUCTOS*/
    public List<Cookware> getAllProducts(){
        return cookwareRepository.getAllProducts();
    }

    public Cookware updateProduct(Cookware cookware){
        Optional<Cookware> validarReferencia = cookwareRepository.findByReference(cookware.getReference());
        if(validarReferencia.isPresent()){
            cookwareRepository.saveProducto(cookware);
        }
        return null;
    }
    public void deleteProduct(String reference){
        Optional<Cookware> validarExistencia = cookwareRepository.findByReference(reference);
        if(validarExistencia.isPresent()){
            cookwareRepository.deleteProduct(reference);
        }
    }
}

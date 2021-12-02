package com.proyecto.reto2.repository;

import com.proyecto.reto2.model.User;
import com.proyecto.reto2.repository.mongoRepository.MongoInterfaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private MongoInterfaceRepository mongoInterfaceRepository;


    /* BUSCAR POR ID*/
    public Optional<User> findById(int id){
        return mongoInterfaceRepository.findById(id);
    }

    /*MOSTRAR TODOS LOS DOCUMENTOS DE LOS USUARIOS*/
    public List<User> getAll(){
       return mongoInterfaceRepository.findAll();
    }

    /* ENCONTRAR UN USUARIO POR EAMIL - BOOLEAN*/
    public boolean findByEmail(String email){
        Optional<User> findUser = mongoInterfaceRepository.findByEmail(email);
        return findUser.isPresent();
    }

    /* BUSCAR POR USUARIO Y PASSWORD PARA VERIFICAR AUTENTICACION*/
    public Optional<User> findByEmailAndPassword(String email, String password){
        return mongoInterfaceRepository.findByEmailAndPassword(email,password);

    }

    /*GUARDAR - ACTUALIZAR USUARIO*/
    public User updateUser(User user){
        return mongoInterfaceRepository.save(user);
    }

    /*BORRAR USUARIO*/
    public void deleteUser(int id){
         mongoInterfaceRepository.deleteById(id);
    }


}

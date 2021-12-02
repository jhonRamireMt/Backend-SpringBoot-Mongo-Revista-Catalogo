package com.proyecto.reto2.service;

import com.proyecto.reto2.model.User;
import com.proyecto.reto2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /* Crear usuario nuevo*/
    public User createUser(User user){
        Optional<User> validarId = userRepository.findById(user.getId());
        if(!validarId.isPresent()){
            boolean validarEmaill = userRepository.findByEmail(user.getEmail());
            if(!validarEmaill){
                return userRepository.updateUser(user);
            }else{
                return null;
            }
        }
        return null;
    }

    /*METOD QUE ELIMINA UN USUARIO DE LA BD*/
    public void deleteUser(int id){
        Optional<User> validarId = userRepository.findById(id);
        if(validarId.isPresent()){
            userRepository.deleteUser(id);
        }
    }

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public boolean findByEmail(String email){
        if(userRepository.findByEmail(email)){
            return true;
        }
        return false;
    }

    /* AUTENTICA USUARIO*/
    public User findByEmailAndPassword(String email, String password){
        Optional<User> user = userRepository.findByEmailAndPassword(email,password);
        if(user.isPresent()){
            return user.get();
        }else{
            return new User(null,null,null,null,null,null,null,null,null);
        }
    }

    /* ACTUALIZAR UN USUARIO, SE VALIDA QUE ID EXISTA PARA REALIZAR LA ACTUALIZACION
    * SEGUNDO SE VALIDA QUE EL EMAIL ENTRANTE SEA DIFERENTE PUESTOA QUE SI ES IGUAL NO SE PUEDE CAMBIAR*/
    public User updateUser(User user){
        Optional<User> validarIdUser = userRepository.findById(user.getId());
        if(validarIdUser.isPresent()){
            boolean validarEmail = userRepository.findByEmail(user.getEmail());
            if(!validarEmail){
                return userRepository.updateUser(user);
            }else{
                return null;
            }
        }
        return null;
    }

}

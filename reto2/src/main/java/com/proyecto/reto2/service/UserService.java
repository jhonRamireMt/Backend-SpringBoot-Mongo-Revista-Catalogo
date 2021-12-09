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
       return userRepository.findByEmail(email);
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

    /* ACTUALIZAR UN USUARIO, SE VALIDA EXISTENCIA DEL ID Y DEL CORREO
    * EN CASO DE NO EXISTIR EL CORREO PERMITE EL CAMBIO*/
    public User updateUser(User user){
        Optional<User> validarIdUser = userRepository.findById(user.getId());
        boolean validarEmail = userRepository.findByEmail(user.getEmail());
        if(validarIdUser.isPresent() && !validarEmail){
            return userRepository.updateUser(user);
        }
        return null;
    }

    public int sumarID(){
        List<User> listaId = userRepository.getAll();
        int id =0;
        for(User user:listaId){
            if(user.getId()>id){
                id = user.getId();
            }
        }
        return id+1;
    }
}

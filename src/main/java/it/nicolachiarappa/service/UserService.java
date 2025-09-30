package it.nicolachiarappa.service;

import it.nicolachiarappa.DTOs.UserDTO;
import it.nicolachiarappa.mappers.UserMapper;
import it.nicolachiarappa.model.User;
import it.nicolachiarappa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;


    public UserDTO getUserById(Long id){
        User user = userRepository.getReferenceById(id);
        return mapper.toDTO(user);
    }

    public UserDTO getUserByUsername(String username){
        Optional<User> user = userRepository.findUserByUsername(username);
        if(user.isPresent()){
            return mapper.toDTO(user.get());
        }
        return null;
    }

    public void saveUser(UserDTO user){
        if(user!=null) {
            User userModel = mapper.toModel(user);
            userRepository.save(userModel);
        }
    }


}

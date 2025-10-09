package it.nicolachiarappa.service;

import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import it.nicolachiarappa.web.dtos.user.request.SignUpRequest;
import it.nicolachiarappa.web.mapper.UserMapper;
import it.nicolachiarappa.web.dtos.user.request.UpdateUserRequest;
import it.nicolachiarappa.model.User;
import it.nicolachiarappa.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;




    public BaseUserDTO getUserById(Long id){
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElse(null);
    }


    public BaseUserDTO getUserByUsername(String username){
        System.out.println(username);
        return userRepository.findByUsername(username)
                .map(userMapper::toDto)
                .orElse(null);
    }

    public BaseUserDTO saveUser(SignUpRequest request){
       User user = userMapper.fromSignUp(request);
       return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public BaseUserDTO updateUser(UpdateUserRequest request){
        Optional<User> user = userRepository.findById(request.getId());
        if(user.isPresent()){
            User userUpdated = userMapper.fromUpdate(user.get(), request);
            return userMapper.toDto(userRepository.save(userUpdated));
        }
        return new BaseUserDTO();
    }


}

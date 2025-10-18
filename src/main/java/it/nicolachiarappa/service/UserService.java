package it.nicolachiarappa.service;

import it.nicolachiarappa.web.dtos.user.BaseUserDTO;
import it.nicolachiarappa.web.dtos.user.request.SignUpRequest;
import it.nicolachiarappa.web.mapper.UserMapper;
import it.nicolachiarappa.web.dtos.user.request.UpdateUserRequest;
import it.nicolachiarappa.model.User;
import it.nicolachiarappa.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper  userMapper;

    @Autowired
    public UserService(UserRepository repo, UserMapper mapper){
        userRepository= repo;
        userMapper = mapper;
    }


    public BaseUserDTO getUserById(Long id){
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElse(null);
    }


    public BaseUserDTO getUserByUsername(String username){
       return userRepository.findByUsername(username)
                .map(userMapper::toDto)
                .orElse(null);
    }

    public BaseUserDTO saveUser(SignUpRequest request){
       User user = userMapper.fromSignUp(request);
       return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public BaseUserDTO updateUser(Long id, @Valid @RequestBody UpdateUserRequest request) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            User userUpdated = userMapper.fromUpdate(user.get(), request);
            return userMapper.toDto(userRepository.save(userUpdated));


        }
        return null;
    }


    public List<BaseUserDTO> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }


    public List<BaseUserDTO> saveMany(List<SignUpRequest> requests){
        return requests.stream()
                .map(this::saveUser)
                .toList();
    }




}

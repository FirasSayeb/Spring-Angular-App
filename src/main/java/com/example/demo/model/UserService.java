package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

   public List<User> getUsers(){
       List<User> users=new ArrayList<>();
       userRepository.findAll().forEach(user -> {
           users.add(user);
       });
       return users;
   }
   public User getUser(Integer id){
       return userRepository.findById(id).orElse(null);
   }
   public void deleteUser(Integer id){
     userRepository.deleteById(id);
   }
   public void addUser(User user ){
       userRepository.save(user);
   }
   public void updateUser(User user,Integer id){
       userRepository.save(user);
   }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}

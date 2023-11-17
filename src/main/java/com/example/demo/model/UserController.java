package com.example.demo.model;

import com.example.demo.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    public UserService userService;

    // standard constructors
@RequestMapping(method = RequestMethod.GET,value = "/users")
    public List<User>  getUsers(){
   return userService.getUsers();
}
@RequestMapping("/users/{id}")
public User getUser(@PathVariable Integer id){
    return userService.getUser(id);
}
@RequestMapping(method = RequestMethod.DELETE,value = "/users/{id}")
public void deleteUser(@PathVariable Integer id){
    userService.deleteUser(id);
}
//@RequestMapping(method = RequestMethod.POST,value = "/users")
public void addUser(@RequestBody User user){ userService.addUser(user);}
   @RequestMapping(method = RequestMethod.POST,value = "/users")
public ResponseEntity<?> loginUser(@RequestBody User userData){
    User user =userService.getUserById(userData.getId());
    if(user.getPassword().equals(userData.getPassword()))
        return ResponseEntity.ok(user);
    return (ResponseEntity<?>) ResponseEntity.internalServerError();
}
}
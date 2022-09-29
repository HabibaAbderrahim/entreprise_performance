package jci.entreprise.performance.controllers;

import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.repositories.UserRepository;
import jci.entreprise.performance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User user) {
        return userService.createUser(user);

    }
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/getOneUser/{id}")
    public ResponseEntity<?> getOneUser(@PathVariable Long id){
        return userService.getUserById(id);
    }



}




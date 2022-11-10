package jci.entreprise.performance.controllers;

import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.repositories.UserRepository;
import jci.entreprise.performance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
//@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User user) {
        return userService.createUser(user);

    }

    @PreAuthorize("hasRole('ROLE_ADMIN)")
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody User user){
        return userService.updateUser(user);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/getOneUser/{id}")
    public ResponseEntity<?> getOneUser(@PathVariable Long id){
        return userService.getUserById(id);
    }



}




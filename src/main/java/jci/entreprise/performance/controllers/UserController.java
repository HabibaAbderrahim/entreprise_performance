package jci.entreprise.performance.controllers;

import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/user")

public class UserController {

    private final UserService userService ;

    @PostMapping("/add_user")
    public ResponseEntity<String> add (@RequestBody User user){
        return userService.createUser(user);
    }



}

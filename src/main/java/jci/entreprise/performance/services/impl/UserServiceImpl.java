package jci.entreprise.performance.services.impl;

import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.repositories.UserRepository;
import jci.entreprise.performance.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserService userService ;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder ;
    @Override
    public ResponseEntity<String> createUser(User user) {
        boolean exist= userRepository.existsByEmail(user.getEmail());
        if(exist){
            return  ResponseEntity.badRequest().header("Email Error","Exists").body("This Email exists already !!");
        }

        if(userRepository.existsByUsername(user.getUsername())){
            return  ResponseEntity.badRequest().header("Username Error","Exists").body("This Username exists already !!");

        }
        String cryptedPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(cryptedPwd);

        userRepository.save(user);
        return ResponseEntity.ok().body("New user added succefully");
    }

    @Override
    public ResponseEntity<String> deleteUser(Long id) {

        return null;
    }

    @Override
    public ResponseEntity<String> updateUser(User user) {

        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }
}

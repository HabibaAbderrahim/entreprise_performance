package jci.entreprise.performance.services.impl;

import jci.entreprise.performance.DTO.LoginDTO;
import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.repositories.UserRepository;
import jci.entreprise.performance.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder ;
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

        if(!userRepository.existsById(id)){
            return  ResponseEntity.badRequest().body("This User doesn't exist!!");
        }
        userRepository.deleteById(id);
        return ResponseEntity.ok().body("User deleted succefully");

    }

    @Override
    public ResponseEntity<String> updateUser(User user) {

        if( !(userRepository.existsByUsernameAndUserId(user.getUsername(),user.getUserId()))){
            if(userRepository.existsByUsername(user.getUsername())){
                return  ResponseEntity.badRequest().body("This Username exist , choose another name!!");

            }
        }

        userRepository.save(user);
        return ResponseEntity.ok().body("User"+user.getUsername()+" updated succefully");


    }

    @Override
    public ResponseEntity<?> getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()){
           return ResponseEntity.badRequest().body("Bad user id !!");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(user.get());
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }



}

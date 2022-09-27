package jci.entreprise.performance.controllers;

import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.repositories.UserRepository;
import jci.entreprise.performance.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/apis/user")
///api/auth/signup
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody User user) {
        return userService.createUser(user);

    }
    @PostMapping("/addwithImage")
    public ResponseEntity<String> addWImg(@RequestBody User user , @RequestParam("image") MultipartFile multipartFile) throws IOException{

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        user.setPhotos(fileName);

        User savedUser = userRepository.save(user);
        String uploadDir = "user-photos/" + savedUser.getUserId();

        //FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return userService.createUser(user);

    }
}




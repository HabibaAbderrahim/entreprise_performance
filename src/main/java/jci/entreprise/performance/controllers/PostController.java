package jci.entreprise.performance.controllers;

import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
public class PostController {

    final private PostService postService ;
    final private ImageService imageService ;
    final private UploadFileController uploadFileController ;



  @PostMapping("/save")
  public ResponseEntity<String> savePost(@RequestParam("file")MultipartFile multipartFile , @RequestBody Post post){

      return postService.createPost(post , multipartFile);

  }


}

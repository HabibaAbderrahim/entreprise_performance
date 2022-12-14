package jci.entreprise.performance.controllers;

import jci.entreprise.performance.DTO.FileUploadResponse;
import jci.entreprise.performance.DTO.PostDTO;
import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;
import jci.entreprise.performance.entities.UploadedFile;
import jci.entreprise.performance.services.FileUploadService;
import jci.entreprise.performance.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
//@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')")

public class PostController {

    final private PostService postService ;
    final private FileUploadService fileUploadService ;



    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(path = "/posts", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<String> savePost(@RequestPart(name = "image") MultipartFile multipartFile , @ModelAttribute PostDTO post) throws IOException {
      UploadedFile img = uploadDb1(multipartFile);
      post.setPostImage(img);
      return postService.createPost(post); }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return postService.deletePost(id);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Post post ,@PathVariable Long id){
        return postService.updatePost(post , id); }

    @GetMapping("/getAllPosts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getOnePostById/{id}")
    public ResponseEntity<?> getOnePost(@PathVariable Long id){
        return postService.getPostById(id);
    }

    //User and Admin
    @GetMapping("/getPostByCategory/{category}")
    public List<Post> getOnePost(@PathVariable PostCategory category){
        return postService.getPostByCategory(category);
    }
    //User and Admin
    @GetMapping("/getPostContains/{character}")
    public ResponseEntity<?> getPostContains(@PathVariable String character){
        return postService.getPostByName(character); }
    //User and Admin
    @GetMapping("/getRecentPosts/{date}")//createdDate for testing the API
    public List<Post> getOldestPosts(@PathVariable String date){
        return postService.getOldestPost(date); }

    //To improve in service
    public UploadedFile uploadDb1(MultipartFile multipartFile)
    {
        UploadedFile uploadedFile = fileUploadService.uploadToDb(multipartFile);
        FileUploadResponse response = new FileUploadResponse();
        if(uploadedFile!=null){
            String downloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/api/v1/download/")
                    .path(uploadedFile.getFileId().toString())
                    .toUriString();
            response.setDownloadUri(downloadUri);
            response.setFileId(uploadedFile.getFileId());
            response.setFileType(uploadedFile.getFileType());
            response.setUploadStatus(true);
            response.setMessage("File Uploaded Successfully!");
            return uploadedFile;

        }
        response.setMessage("Oops 1 something went wrong please re-upload.");
        return null;
    }



}

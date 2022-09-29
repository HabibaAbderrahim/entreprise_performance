package jci.entreprise.performance.controllers;

import jci.entreprise.performance.FileUploadResponse;
import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;
import jci.entreprise.performance.entities.UploadedFile;
import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.services.FileUploadService;
import jci.entreprise.performance.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/post")
@AllArgsConstructor
public class PostController {

    final private PostService postService ;
    final private FileUploadService fileUploadService ;



    @RequestMapping(path = "/posts", method = RequestMethod.POST, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<String> savePost(@RequestPart(name = "file") MultipartFile multipartFile , @ModelAttribute Post post) throws IOException {
      UploadedFile img = uploadDb1(multipartFile);
      post.setPostImage(img);
      return postService.createPost(post); }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return postService.deletePost(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody Post post ,@PathVariable Long id){
        return postService.updatePost(post , id); }
    @GetMapping("/getAllPosts")
    public List<Post> getAllPosts(){
        return postService.getAllPosts();
    }
    @GetMapping("/getOnePostById/{id}")
    public ResponseEntity<?> getOnePost(@PathVariable Long id){
        return postService.getPostById(id);
    }
    @GetMapping("/getPostByCategory/{category}")
    public List<Post> getOnePost(@PathVariable PostCategory category){
        return postService.getPostByCategory(category);
    }
    @GetMapping("/getPostContains/{character}")
    public ResponseEntity<?> getPostContains(@PathVariable String character){
        return postService.getPostByName(character); }
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

package jci.entreprise.performance.services;

import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface PostService {
    //Admin
    public ResponseEntity<String>  createPost(Post post , MultipartFile file );//admin
    public ResponseEntity<String>  deletePost(Long id);//admin
    public ResponseEntity<String>  updatePost(Post post);//admin
    public List<Post> getAllPosts(); //admin user
    public List<Post>getPostByCategory(PostCategory category);//user admin
    public List<Post>getRecentPost ();//sort
    public List<Post>getOldestPost ();//sort
    public List<Post> getPostContains(String characters);



}

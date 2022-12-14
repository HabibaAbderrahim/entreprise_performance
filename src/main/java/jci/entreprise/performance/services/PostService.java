package jci.entreprise.performance.services;

import jci.entreprise.performance.DTO.PostDTO;
import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostService {
    //Admin
    public ResponseEntity<String>  createPost(PostDTO postDTO);//admin
    public ResponseEntity<String>  deletePost(Long id);//admin
    public ResponseEntity<String>  updatePost(Post post , Long id);//admin
    public List<Post> getAllPosts(); //admin user
    public ResponseEntity<?>getPostById(Long id);//admin
    public List<Post>getPostByCategory(PostCategory category );//user admin
    public ResponseEntity<?>getPostByName(String name );
    public List<Post>getOldestPost (String date);//sort

}

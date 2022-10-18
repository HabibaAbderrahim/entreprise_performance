package jci.entreprise.performance.services.impl;

import jci.entreprise.performance.DTO.PostDTO;
import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;
import jci.entreprise.performance.entities.UploadedFile;
import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.mapper.PostMapper;
import jci.entreprise.performance.repositories.PostRepository;
import jci.entreprise.performance.repositories.UserRepository;
import jci.entreprise.performance.services.FileUploadService;
import jci.entreprise.performance.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    final private PostRepository postRepository;
    final private FileUploadService fileUploadService;
    final private UserRepository userRepository ;
    final private PostMapper postMapper ;
    @Override
    public ResponseEntity<String> createPost(PostDTO postDTO) {

        //user
        User user = userRepository.findById(postDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("Not found"));

        Post post = postMapper.map(postDTO , user);

        postRepository.save(post);
        return ResponseEntity.status(HttpStatus.OK).body("Post saved successfully") ;
    }

    @Override
    public ResponseEntity<String> deletePost(Long id) {

        if(!postRepository.existsById(id)){
            return ResponseEntity.badRequest().body("There No post To delete");
        }
        postRepository.deleteById(id);
        return ResponseEntity.ok().body("Post Deleted successfully");
    }

    @Override
    public ResponseEntity<String> updatePost(Post post , Long id) {
        //Find Post
        Optional<Post> oldPost = postRepository.findById(id);
        if (!oldPost.isEmpty()){
            //Update Post
            Post p = oldPost.get();
            p.setPostName(post.getPostName());
            p.setDescription(post.getDescription());
            p.setPostImage(post.getPostImage());
            p.setUpdatedDate(post.getUpdatedDate());
            p.setCreatedDate(post.getUpdatedDate());
            p.setPostCategory(post.getPostCategory());
            postRepository.save(p);
            return ResponseEntity.ok().body("Post Updated successfully");
        }

        return ResponseEntity.badRequest().body("There No post !!");
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public ResponseEntity<?> getPostById(Long id) {
        Optional<Post> p = postRepository.findById(id);
        if (!p.isPresent()){
            return ResponseEntity.badRequest().body("Bad Post id !!");
        }
        return ResponseEntity.ok().body(p.get());
    }

    @Override
    public List<Post> getPostByCategory(PostCategory category) {
        //if category not in Post Category
        //PostCategory cat = PostCategory.findByValue(category);
        return postRepository.findByPostCategory(category);

    }

    @Override
    public ResponseEntity<?> getPostByName(String name) {

        List<Post> posts = postRepository.findByPostNameContainingIgnoreCase(name);
        if (posts.isEmpty()){
            return  ResponseEntity.badRequest().body("There are no posts with name"+name);
        }
        return ResponseEntity.ok().body(posts);
    }

    @Override
    public List<Post> getOldestPost(String date) {
        return postRepository.findAll(Sort.by(Sort.Direction.DESC , String.valueOf(date)));
    }





}

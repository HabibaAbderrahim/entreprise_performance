package jci.entreprise.performance.services.impl;

import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;
import jci.entreprise.performance.entities.UploadedFile;
import jci.entreprise.performance.repositories.PostRepository;
import jci.entreprise.performance.services.FileUploadService;
import jci.entreprise.performance.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    final private PostRepository postRepository;
    final private FileUploadService fileUploadService;
    @Override
    public ResponseEntity<String> createPost(Post post) {

        postRepository.save(post);
        return ResponseEntity.status(HttpStatus.OK).body("Post saved succesfully") ;

    }

    @Override
    public ResponseEntity<String> deletePost(Long id) {

        return null;
    }

    @Override
    public ResponseEntity<String> updatePost(Post post) {

        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(PostCategory category) {
        return null;
    }

    @Override
    public List<Post> getRecentPost() {
        return null;
    }

    @Override
    public List<Post> getOldestPost() {
        return null;
    }

    @Override
    public List<Post> getPostContains(String characters) {
        return null;
    }
}

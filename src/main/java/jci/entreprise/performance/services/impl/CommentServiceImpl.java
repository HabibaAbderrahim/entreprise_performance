package jci.entreprise.performance.services.impl;

import jci.entreprise.performance.DTO.CommentsDto;
import jci.entreprise.performance.entities.Comment;
import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.User;
import jci.entreprise.performance.mapper.CommentMapper;
import jci.entreprise.performance.repositories.CommentRepository;
import jci.entreprise.performance.repositories.PostRepository;
import jci.entreprise.performance.repositories.UserRepository;
import jci.entreprise.performance.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {


    final private CommentRepository commentRepository ;
    final private PostRepository postRepository ;
    final private UserRepository userRepository ;
    @Autowired
    private CommentMapper commentMapper ;
    @Override
    public ResponseEntity<String> createComment(CommentsDto commentsDto) {
        /*Optional<Post> post = postRepository.findById(commentsDto.getPostId()); // data from dto
        if (post.isEmpty()){
            return ResponseEntity.badRequest().body("There No post !!");
        }
        Optional<User> user = userRepository.findById(commentsDto.getUserId());
        if (post.isEmpty()){
            return ResponseEntity.badRequest().body("There No post !!");
        }*/
        Post post = postRepository.findById(commentsDto.getPostId()).orElseThrow(() -> new IllegalArgumentException("Not found"));
        User user = userRepository.findById(commentsDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("Not found"));
        Comment comment = commentMapper.map(commentsDto , post , user);
        commentRepository.save(comment);
        return  ResponseEntity.ok().body("NICE COMMENT");



    }

    @Override
    public ResponseEntity<String> deleteComment(Long id) {

        return null;
    }

    @Override
    public boolean containsSwearWords(String comment) {
        return false;
    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public List<Comment> getUserComment(Long userId) {
        return null;
    }

    @Override
    public List<Comment> getAllCommInPost(Long postId) {
        return null;
    }

    @Override
    public List<Comment> getRecentComm() {
        return null;
    }

    @Override
    public List<Comment> getOldestComm() {
        return null;
    }
}

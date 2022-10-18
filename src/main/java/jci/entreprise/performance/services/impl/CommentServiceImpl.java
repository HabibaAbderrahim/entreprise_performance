package jci.entreprise.performance.services.impl;

import jci.entreprise.performance.DTO.CommentDTO;
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
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {


    final private CommentRepository commentRepository ;
    final private PostRepository postRepository ;
    final private UserRepository userRepository ;
    @Autowired
    private CommentMapper commentMapper ;
    @Override
    public ResponseEntity<String> createComment(CommentDTO commentDTO) {


        Post post = postRepository.findById(commentDTO.getPostId()).orElseThrow(() -> new IllegalArgumentException("Not found"));
        User user = userRepository.findById(commentDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("Not found"));
        Comment comment = commentMapper.map(commentDTO, post , user);
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

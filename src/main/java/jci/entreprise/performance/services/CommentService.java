package jci.entreprise.performance.services;

import jci.entreprise.performance.DTO.CommentDTO;
import jci.entreprise.performance.entities.Comment;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommentService {

    public ResponseEntity<String> createComment(CommentDTO commentDTO);
    public ResponseEntity<String>  deleteComment (Long id);
    public ResponseEntity<String> containsSwearWords(String comment);
    public List<Comment> getAllComments();
    public List<Comment> getUserComment(Long userId);
    public List<Comment> getAllCommInPost(Long postId);
    public List<Comment>getRecentComm ();//sort
    public List<Comment>getOldestComm ();//sort

}

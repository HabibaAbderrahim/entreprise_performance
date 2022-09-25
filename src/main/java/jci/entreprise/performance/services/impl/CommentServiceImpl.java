package jci.entreprise.performance.services.impl;

import jci.entreprise.performance.entities.Comment;
import jci.entreprise.performance.services.CommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public ResponseEntity<String> createComment(Comment comment) {

        return null;
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

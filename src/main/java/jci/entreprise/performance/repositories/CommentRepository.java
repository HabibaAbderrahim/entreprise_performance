package jci.entreprise.performance.repositories;

import jci.entreprise.performance.entities.Comment;
import jci.entreprise.performance.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment , Long> {
    public List<Comment> findAllOrderByAsc(); //arrow
    public List<Comment> findAllOrderByDesc();
}

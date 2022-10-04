package jci.entreprise.performance.repositories;

import jci.entreprise.performance.entities.Comment;
import jci.entreprise.performance.entities.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;


public interface CommentRepository extends JpaRepository<Comment , Long> {
    public List<Comment> findAll(Sort sort); //arrow
    //public List<Comment> findByOrderByCreateDateDesc();
}

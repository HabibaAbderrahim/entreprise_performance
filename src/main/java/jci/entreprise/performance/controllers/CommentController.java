package jci.entreprise.performance.controllers;

import jci.entreprise.performance.DTO.CommentsDto;
import jci.entreprise.performance.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments/")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping
    public ResponseEntity<String> createComment(@RequestBody CommentsDto commentsDto) {
        return commentService.createComment(commentsDto)  ;

        }
}

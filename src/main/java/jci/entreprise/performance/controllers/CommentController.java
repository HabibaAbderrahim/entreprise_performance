package jci.entreprise.performance.controllers;

import jci.entreprise.performance.DTO.CommentDTO;
import jci.entreprise.performance.services.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments/")
@AllArgsConstructor
//@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')")
public class CommentController {

    private final CommentService commentService;

    //For User and Admiin
    @PostMapping
    public ResponseEntity<String> createComment(@RequestBody CommentDTO commentDTO) {
        return commentService.createComment(commentDTO)  ;

        }
}

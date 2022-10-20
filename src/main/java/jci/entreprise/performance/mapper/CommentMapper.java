package jci.entreprise.performance.mapper;

import jci.entreprise.performance.DTO.CommentDTO;
import jci.entreprise.performance.entities.Comment;
import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "text", source = "commentDTO.text")
    @Mapping(target = "createDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")
    Comment map(CommentDTO commentDTO, Post post, User user);

    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
    @Mapping(target = "userId", expression = "java(comment.getUser().getUserId())")
    CommentDTO mapToDto(Comment comment);


}


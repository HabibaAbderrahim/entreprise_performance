package jci.entreprise.performance.mapper;

import jci.entreprise.performance.DTO.CommentsDto;
import jci.entreprise.performance.entities.Comment;
import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "createDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "text", source = "commentsDto.text")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")



    Comment map(CommentsDto commentsDto, Post post, User user);


}

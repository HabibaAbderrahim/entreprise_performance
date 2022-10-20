package jci.entreprise.performance.mapper;

import jci.entreprise.performance.DTO.PostDTO;
import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {


    @Mapping(target = "postName", source = "postDTO.postName")
    @Mapping(target = "description", source = "postDTO.description")
    @Mapping(target = "postCategory", source = "postDTO.postCategory")
    @Mapping(target = "postImage", source = "postDTO.postImage")
    //@Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "user", source = "user")
    Post map(PostDTO postDTO, User user);

    @Mapping(target = "userId", expression = "java(post.getUser().getUserId())")
    PostDTO mapToDto(Post post);}


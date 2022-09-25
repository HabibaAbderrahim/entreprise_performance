package jci.entreprise.performance.services;

import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;

import java.util.Date;
import java.util.List;

public interface PostService {
    //Admin
    public void createPost(Post post);//admin
    public void deletePost(Long id);//admin
    public void updatePost(Post post);//admin
    public List<Post> getAllPosts(); //admin user
    public List<Post>getPostByCategory(PostCategory category);//user admin
    public List<Post>getRecentPost ();//sort
    public List<Post>getOldestPost ();//sort
    public List<Post> getPostContains(String characters);



}

package jci.entreprise.performance.services.impl;

import jci.entreprise.performance.entities.Post;
import jci.entreprise.performance.entities.PostCategory;
import jci.entreprise.performance.services.PostService;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public void createPost(Post post) {

    }

    @Override
    public void deletePost(Long id) {

    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public List<Post> getPostByCategory(PostCategory category) {
        return null;
    }

    @Override
    public List<Post> getRecentPost() {
        return null;
    }

    @Override
    public List<Post> getOldestPost() {
        return null;
    }

    @Override
    public List<Post> getPostContains(String characters) {
        return null;
    }
}

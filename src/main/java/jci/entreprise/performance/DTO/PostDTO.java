package jci.entreprise.performance.DTO;

import jci.entreprise.performance.entities.PostCategory;
import jci.entreprise.performance.entities.UploadedFile;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;

@Data
@NoArgsConstructor
public class PostDTO {

    private Long postId ;
    private String postName ;
    private Instant createdDate = Instant.now() ;
    private String description ;
    private PostCategory postCategory ;
    private UploadedFile postImage ;
    private Long userId ;

    public PostDTO(String postName, String description, PostCategory postCategory, UploadedFile postImage, Long userId) {
        this.postName = postName;
        this.description = description;
        this.postCategory = postCategory;
        this.postImage = postImage;
        this.userId = userId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }

    public UploadedFile getPostImage() {
        return postImage;
    }

    public void setPostImage(UploadedFile postImage) {
        this.postImage = postImage;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = Instant.now();
    }
}

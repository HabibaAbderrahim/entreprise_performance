package jci.entreprise.performance.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId ;
    private String postName ;
    private Instant createdDate ;
    private Instant updatedDate ;
    @Lob
    private String description ;
    //one to one
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn( name="uploadedFile" , referencedColumnName = "fileId" )
    private UploadedFile postImage ;
    //one to one
    private PostCategory postCategory ;
    //relation POST COMMENT
    @OneToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Comment> comments ;
    //user

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId" , referencedColumnName = "userId")
    @JsonIgnore
    @JsonIgnoreProperties({ "createDate", "role","password","username" })
    private  User user ;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Instant updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UploadedFile getPostImage() {
        return postImage;
    }

    public void setPostImage(UploadedFile postImage) {
        this.postImage = postImage;
    }

    public PostCategory getPostCategory() {
        return postCategory;
    }

    public void setPostCategory(PostCategory postCategory) {
        this.postCategory = postCategory;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

/*@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "post_images",
    joinColumns = {
            @JoinColumn(name = "post_id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "image_id")
    }
    )
    @JsonIgnore
    private Set<ImageModel> postImage ;*/


}

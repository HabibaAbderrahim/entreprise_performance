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
import java.time.Instant;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
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
    @JoinColumn( name="image" , referencedColumnName = "fileId" )
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

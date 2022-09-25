package jci.entreprise.performance.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Blob;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId ;
    @NotNull
    private String postName ;
    private Instant createdDate ;
    @Nullable
    private Blob postImage ;
    private Instant updatedDate ;
    @Lob
    private String description ;
    //one to one
    private PostCategory postCategory ;
    //relation POST COMMENT
    @OneToMany(fetch = FetchType.LAZY)
    private List<Comment> comments ;
    //user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId" , referencedColumnName = "userId")
    private  User user ;

}

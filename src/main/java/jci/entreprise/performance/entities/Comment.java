package jci.entreprise.performance.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comId ;
    @NotNull
    @Lob
    private String text ;
    private Instant createDate ;
    //relations: user comment
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId" , referencedColumnName = "userId")
    private User user ;
    //post comment
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId" , referencedColumnName = "postId")
    private Post post ;

}

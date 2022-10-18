package jci.entreprise.performance.entities;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long userId ;
    @NotNull
    private String username ;
    @Column(nullable = true, length = 64)
    private String photos;
    @NotNull
    private  String password ;
    @NotNull
    private String email ;
    @Nullable
    private Instant createDate ;
    private String role ;

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || userId == null) return null;

        return "/user-photos/" + userId + "/" + photos;
    }


}

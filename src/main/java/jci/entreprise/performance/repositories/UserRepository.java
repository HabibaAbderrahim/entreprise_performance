package jci.entreprise.performance.repositories;

import jci.entreprise.performance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {

    boolean existsByUsername (String uesrname);
    boolean existsByEmail (String email);
    boolean existsByUsernameAndUserId(String username , Integer id);
    public User findOneByUsername(String username);
}

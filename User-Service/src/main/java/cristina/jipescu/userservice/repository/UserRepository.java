package cristina.jipescu.userservice.repository;

import cristina.jipescu.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    boolean findByEmail(String email);
}

package cristina.jipescu.userservice.service;

import cristina.jipescu.userservice.model.User;
import cristina.jipescu.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String id) {
        return userRepository.getById(id);
    }

    public boolean addUser(User user) {
        if (userRepository.findByEmail(user.getEmail())) {
            return true;
        }
        userRepository.save(user);
        return false;
    }

    public boolean updateUser(String id) {
        if (userRepository.existsById(id)) {
            return false;
        }
        userRepository.save(userRepository.getById(id));
        return true;
    }

    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            return false;
        }
        userRepository.delete(userRepository.getById(id));
        return true;
    }
}

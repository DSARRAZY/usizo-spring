package dyd.usizo.service;

import dyd.usizo.accessingdatamysql.UserRepository;
import dyd.usizo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service("userService")
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByNom(username);
    }
}
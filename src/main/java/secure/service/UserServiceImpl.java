package secure.service;

import org.springframework.stereotype.Service;
import secure.entity.User;
import secure.service.interfaces.UserService;

@Service
public class UserServiceImpl implements UserService {
//    @Override
    public User getUser(String login) {

        // здесь вызваем метод из DAO, который достет юзера с БД или получает его с Web Service.

        User user = new User();
        user.seteMail(login);
        user.setPassword("1234");

        return user;
    }
}

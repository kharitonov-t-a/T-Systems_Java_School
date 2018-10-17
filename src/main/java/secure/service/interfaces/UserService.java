package secure.service.interfaces;

import secure.entity.User;

public interface UserService {
    User getUser(String login);
}

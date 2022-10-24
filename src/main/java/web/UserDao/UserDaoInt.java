package web.UserDao;

import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

public interface UserDaoInt {

    List<User> index();

    User show(int id);

    void save(User user);

    void update(int id, User userUpDate);

    void delete(int id);


}

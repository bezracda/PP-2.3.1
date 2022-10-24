package web.Servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.UserDao.UserDao;
import web.UserDao.UserDaoInt;
import web.model.User;

import java.util.List;


@Service
public class UserService implements UserServiceInt {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public List<User> index() {
        return userDao.index();
    }

    @Transactional
    public User show(int id) {
        return userDao.show(id);
    }

    @Transactional
    public void save(User user) {
        userDao.save(user);
    }

    @Transactional
    public void update(int id, User userUpDate) {
        userDao.update(id, userUpDate);
    }

    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}


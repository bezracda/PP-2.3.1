package web.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao implements UserDaoInt {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> index() {
        TypedQuery<User> query = entityManager.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public User show(int id) {
        User userId = entityManager.find(User.class, id);
        return userId;

    }


    @Override
    public void save(User user) {
        entityManager.persist(user);

    }

    @Override
    public void update(int id, User userUpDate) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(userUpDate.getName());
        userToBeUpdated.setLevel(userUpDate.getLevel());
    }


    @Override
    public void delete(int id) {
        User user = show(id);
        entityManager.remove(user);
    }
}

package web.UserDao;
import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDao {
    private int PEOPLE_COUNT;
    private List<User> users = new ArrayList<>();

    {
        users.add(new User(++PEOPLE_COUNT, "Kirill", "junior"));
        users.add(new User(++PEOPLE_COUNT, "Vasta", "junior"));
        users.add(new User(++PEOPLE_COUNT, "Petya", "junior"));
        users.add(new User(++PEOPLE_COUNT, "Jenya", "junior"));

    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }

    public void update(int id, User userUpDate) {
        User user = show(id);
        user.setName(userUpDate.getName());
        user.setLevel(userUpDate.getLevel());
    }

    public void delete(int id) {
        users.removeIf(p -> p.getId() == id);
    }
}

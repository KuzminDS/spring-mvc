package com.ssu.kuzmin.mvc.dao.fake;

import com.ssu.kuzmin.mvc.dao.IUserDao;
import com.ssu.kuzmin.mvc.entities.MedicalCard;
import com.ssu.kuzmin.mvc.entities.User;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDao implements IUserDao {
    private static Map<Integer, User> users;

    static {
        users = new HashMap<>();
        MedicalCard medicalCard = new MedicalCard(1);
        users.put(1, new User(1, "Петров", "Петр", "Петрович", "user1@hosp.com", "123", "user1", medicalCard));
        medicalCard = new MedicalCard(2);
        users.put(2, new User(2, "Емельянов", "Емельян", "Емельянович", "user2@hosp.com", "123", "user2", medicalCard));
    }

    @Override
    public User add(User user) {
        int id = users.keySet().stream().mapToInt(v -> v).max().getAsInt() + 1;
        user.setId(id);
        MedicalCard medicalCard = new MedicalCard(id);
        user.setMedicalCard(medicalCard);
        users.put(id, user);
        return user;
    }

    @Override
    public User update(User user) throws Exception {
        if (!users.containsKey(user.getId())) {
            throw new Exception("User with id " + user.getId() + " does not exist");
        }
        users.replace(user.getId(), user);
        return user;
    }

    @Override
    public void delete(User user) throws Exception {
        if (!users.containsKey(user.getId())) {
            throw new Exception("User with id " + user.getId() + " does not exist");
        }
        users.remove(user.getId());
    }

    @Override
    public User getById(int id) throws Exception {
        if (!users.containsKey(id)) {
            throw new Exception("User with id " + id + " does not exist");
        }
        return users.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }
}

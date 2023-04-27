package com.mdbytes.bbc.utils;

import com.mdbytes.bbc.dao.user.UserDAO;
import com.mdbytes.bbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserUtils implements Utils {

    private UserDAO userDAO;

    @Autowired
    public UserUtils(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void createManyGetAll() {
        System.out.println("Creating user objects...");

        User userOne = new User("Martin", "Dwyer", "martin@mdbytes.com", "Be235Again!", "true");
        User userTwo = new User("Martin", "Dwyer", "martin.dwyer@outlook.com", "Pickles01@", "false");

        // save the student object
        System.out.println("Saving...");
        userDAO.save(userOne);
        userDAO.save(userTwo);

        // display the students
        List<User> users = userDAO.getAll();
        for (User user : users) {
            System.out.println(user.toString());
        }
    }

    @Override
    public void updateOne() {
        User user = userDAO.get(1);
        System.out.println(user.toString());

        user.setEmailAddress("martin@me.com");
        userDAO.update(user);

        User revisedUser = userDAO.get(1);

        System.out.println("Revised from DB:");
        System.out.println(revisedUser.toString());

    }

    @Override
    public void deleteOne() {
        System.out.println("Deleting user 2...");
        userDAO.delete(2);
        System.out.println("user 2 deleted");
    }

    @Override
    public void deleteAll() {
        System.out.println("Deleting all users");
        userDAO.deleteAll();
        System.out.println("All users deleted.");

    }
}

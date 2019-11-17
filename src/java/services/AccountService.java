package services;

import dataaccess.UserDB;
import models.User;

public class AccountService {

    public User login(String username, String password) {
        try {
            UserDB userDB = new UserDB();
            User user = userDB.getUser(username);

            if (user.getPassword().equals(password)) {
                return user;
            }
        } catch (Exception e) {

        }

        return null;
    }
}

package com.example.myProject.data;
import java.util.ArrayList;
import java.util.List;
import com.example.myProject.models.User;

public class usersData {
    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User("Daniel", "Florencio", 1159.7));
    }

}
package com.sbp.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "A", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount, "B", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount, "C", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId() == id ;
       return users.stream().filter(predicate).findFirst().get();
    }

    public User save(User user){
        User savedUser = new User(++userCount, user.getName(),user.getBirthDate());
        users.add(savedUser);
        return savedUser;
    }
}

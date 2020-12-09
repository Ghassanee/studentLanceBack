package com.StudentLance.demo.ServiceInterface;

import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserServiceInt {

    User findByUserRef(String userRef);

    User findByPhone(String phone);

    User findByEmail( String email);

    User createUser(User user, boolean create);

    User updateUser(User user);

    User login(String email, String password);

    //ResponseEntity addImage(int userid, String image);

    List<Interview> getUserInterviews(String userRef);

    List<User> findAll();


}

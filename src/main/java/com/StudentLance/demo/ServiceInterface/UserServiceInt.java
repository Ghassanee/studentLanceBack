package com.StudentLance.demo.ServiceInterface;

import com.StudentLance.demo.DAO.UserDAO;
import com.StudentLance.demo.Entity.User;
import org.springframework.http.ResponseEntity;

public interface UserServiceInt {

    public User getUser(String email);

    public User getUserByID(int id);

    public ResponseEntity createUser(String firstname, String lastname, String phone, String email, String password,
                                     String address, String education, String skills, Float experience,
                                     String introduction, String status, String image);

    public ResponseEntity<Object> updateUser(int id, String parameter, String value);

    public ResponseEntity addImage(int userid, String image);

    public ResponseEntity getUserInterviews(int userid);


}

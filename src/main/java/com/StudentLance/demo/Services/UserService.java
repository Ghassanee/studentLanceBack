package com.StudentLance.demo.Services;

import com.StudentLance.demo.DAO.*;
import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Entity.User;
import com.StudentLance.demo.ServiceInterface.UserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInt{

    @Autowired
    private UserDAO userDao;

    @Autowired
    private InterviewDAO interviewDAO;


    @Override
    public User findByUserRef(String userRef) {
        return userDao.findByUserRef(userRef);
    }

    @Override
    public User findByPhone(String phone) {
        return userDao.findByPhone(phone);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User createUser(User user, boolean create) {
        User foundedRef = userDao.findByUserRef(user.getUserRef());
        User foundedEmail = userDao.findByEmail(user.getEmail());
        User foundedPhone = userDao.findByPhone(user.getPhone());
        try {
            if (foundedRef != null && create) throw new Exception("User Reference already exist, User Ref :" + user.getUserRef());
            else if (foundedRef == null && !create) throw new Exception("User doesn't exist, User Ref :" + user.getUserRef());
            // else if (foundedEmail != null) throw new Exception("User Email already exist, Email  :" + user.getEmail());
            // else if (foundedPhone != null) throw new Exception("User Phone already exist, Phone :" + user.getPhone());

        }catch (Exception e){
            System.out.println("failed to create/update a  User ");
            return null;
        }
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        return createUser(user, false);
    }

    @Override
    public User login(String email, String password) {
        User foundedEmail = userDao.findByEmail(email);
        try {
            if (foundedEmail != null) throw new Exception("User Email doesn't exist, Email  :" + email);
            if (!foundedEmail.getPassword().equals(password)) throw new Exception("Password and Email don't match  " );

        }catch (Exception e){
            System.out.println("failed to LogIn ");
            return null;
        }
        return foundedEmail;
    }

    @Override
    public List<Interview> getUserInterviews(String userRef) {
        return interviewDAO.findByUser(userDao.findByUserRef(userRef));
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }


}

package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

    public User findByuserId(int id);

    public User findUserByPhone(String phone);

    public User findUserByEmail(String email);

}


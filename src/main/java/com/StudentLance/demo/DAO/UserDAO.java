package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

    User findByUserRef(String userRes);

    User findByPhone(String phone);

    User findByEmail( String email);

    List<User> findAll();

}


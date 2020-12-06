package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserDAO extends JpaRepository<User,Long> {

    public User findByuserId(int id);

    @Query("select * from User u  where u.phone = :phone")
    public User findUserByPhone(@Param("phone") String phone);

    @Query("select * from User u where u.email = :email")
    public User findUserByEmail(@Param("email") String email);

}


package com.StudentLance.demo.DAO;

import java.util.Optional;

import com.StudentLance.demo.Entity.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {

    Optional<ImageModel> findByName(String name);

}
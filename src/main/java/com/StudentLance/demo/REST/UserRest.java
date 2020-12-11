package com.StudentLance.demo.REST;

import com.StudentLance.demo.Entity.ImageModel;
import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Entity.User;
import com.StudentLance.demo.Services.ImageUploadService;
import com.StudentLance.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/StudentLance/User")
public class UserRest {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageUploadService imageUploadService;


    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {
        List<User> userList = userService.findAll();
        return userList != null ? ResponseEntity.status(OK)
                .body(userList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/users/{ref}")
    public ResponseEntity<User> findByUserRef(@PathVariable("ref") String userRef) {
        User user = userService.findByUserRef(userRef);
        return user != null ? ResponseEntity.status(OK)
                .body(user)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/users/phone/{phone}")
    public ResponseEntity<User> findByPhone(@PathVariable("phone") String phone) {
        User user = userService.findByPhone(phone);
        return user != null ? ResponseEntity.status(OK)
                .body(user)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable("email") String email) {
        User user = userService.findByEmail(email);
        return user != null ? ResponseEntity.status(OK)
                .body(user)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/users/login/{email}/{password}")
    public ResponseEntity<User> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        User user = userService.login(email, password);
        return user != null ? ResponseEntity.status(OK)
                .body(user)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/getImage")
    public ResponseEntity<ImageModel> getImage(@RequestPart(required=true) String userRef ) throws IOException {
        ImageModel photo = imageUploadService.getImage(userService.findByUserRef(userRef).getPhoto().getName());
        return photo != null ? ResponseEntity.status(OK)
                .body(photo)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/user/getInterviews/{id}")
    public ResponseEntity<List<Interview>> getUserInterviews(@PathVariable(value="id") String userId) {
        List<Interview> interviewList = userService.getUserInterviews(userId);
        return interviewList != null ? ResponseEntity.status(OK)
                .body(interviewList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @PostMapping("/create")
    public ResponseEntity<User> create(@RequestBody User user ) throws IOException {
        User createdUser = userService.createUser(user, true);
        return createdUser != null ? ResponseEntity.status(OK)
                .body(createdUser)
                :ResponseEntity.status(FORBIDDEN)
                .body(null);
    }

    @PutMapping("/postImage")
    public ResponseEntity<User> postImage(@RequestPart(required=true) String userRef ,@RequestPart(value="file", required = true)  MultipartFile file ) throws IOException {
        User user = userService.findByUserRef(userRef);
        if (user == null ) return ResponseEntity.status(FORBIDDEN)
                .body(null);
        if (file != null ) user.setPhoto(imageUploadService.uplaodImage(file));
        User createdUser = userService.updateUser(user);
        return createdUser != null ? ResponseEntity.status(OK)
                .body(createdUser)
                :ResponseEntity.status(FORBIDDEN)
                .body(null);
    }

    @PutMapping("/user/update")
    public ResponseEntity<User> update(@RequestBody User user) throws IOException {
        User createdUser = userService.updateUser(user);
        return createdUser != null ? ResponseEntity.status(OK)
                .body(createdUser)
                :ResponseEntity.status(FORBIDDEN)
                .body(null);
    }
}

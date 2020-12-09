package com.StudentLance.demo.REST;

import com.StudentLance.demo.Entity.ImageModel;
import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Entity.User;
import com.StudentLance.demo.Services.ImageUploadService;
import com.StudentLance.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/StudentLance/User")
public class UserRest {

    @Autowired
    private UserService userService;

    @Autowired
    private ImageUploadService imageUploadService;

    @GetMapping("/users/{ref}")
    public ResponseEntity<User> findByUserRef(@PathVariable("ref") String userRef) {
        return ResponseEntity.status(OK)
                .body(userService.findByUserRef(userRef));
    }

    @GetMapping("/users/phone/{phone}")
    public ResponseEntity<User> findByPhone(@PathVariable("phone") String phone) {
        return ResponseEntity.status(OK)
                .body(userService.findByPhone(phone));
    }

    @GetMapping("/users/email/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable("email") String email) {
        return ResponseEntity.status(OK)
                .body(userService.findByEmail(email));
    }
    @GetMapping("/users/login/{email}/{password}")
    public ResponseEntity<User> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        return ResponseEntity.status(OK)
                .body(userService.login(email, password));
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(OK)
                .body(userService.findAll());
    }

    @GetMapping("/getImage")
    public ResponseEntity<ImageModel> getImage(@RequestPart(required=true) String userRef ) throws IOException {
        return ResponseEntity.status(OK)
                .body(imageUploadService.getImage(userService.findByUserRef(userRef).getPhoto().getName()));
    }

    @PostMapping("/create")
    public ResponseEntity<User> create( @RequestBody User user ) throws IOException {
        return ResponseEntity.status(OK)
                .body(userService.createUser(user, true));
    }
    @PutMapping("/postImage")
    public ResponseEntity<User> postImage(@RequestPart(required=true) String userRef ,@RequestPart(value="file", required = true)  MultipartFile file ) throws IOException {
        User user = userService.findByUserRef(userRef);
        if (file != null) {
            user.setPhoto(imageUploadService.uplaodImage(file));
        }
        return ResponseEntity.status(OK)
                .body(userService.updateUser(user));
    }

    @PutMapping("/user/update")
    public ResponseEntity<User> update(@RequestPart(required=true) User user, @RequestPart(value="file", required = true)  MultipartFile file) throws IOException {
        if (file != null) {
            user.setPhoto(imageUploadService.uplaodImage(file));
        }
        return ResponseEntity.status(OK)
                .body(userService.updateUser(user));
    }

    @GetMapping("/user/getInterviews/{id}")
    public ResponseEntity<List<Interview>> getUserInterviews(@PathVariable(value="id") String userId) {
        return ResponseEntity.status(OK)
                .body(userService.getUserInterviews(userId));
    }

}

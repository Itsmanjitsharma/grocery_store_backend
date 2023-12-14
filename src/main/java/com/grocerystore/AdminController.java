package com.grocerystore;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grocerystore.store.AuthenticationService;
import com.grocerystore.store.UserInfo;

@RestController
@CrossOrigin(origins = "http://62.72.57.113:5173")
public class AdminController {

    AuthenticationService authenticationService;

    public AdminController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/getAdminUsers")
    public List<UserInfo> getAllUserInfo() {
        return authenticationService.getAllUserInfo();
    }

    @PostMapping("/addAdminUsers")
    public void addUser(@RequestBody UserInfo admin) {
        authenticationService.addNewUser(admin);
    }

    @DeleteMapping("/deleteAdminUsers")
    public void deleteUser(@RequestParam(value = "username") String username,
            @RequestParam(value = "businessname") String businessname) {
        System.out.println(businessname + " " + username);
        authenticationService.deleteUser(username, businessname);
    }

    @PutMapping("/getUpdateAdminUsers")
    public void updateUser(@RequestBody UserInfo admin) {
        authenticationService.addNewUser(admin);
    }

}

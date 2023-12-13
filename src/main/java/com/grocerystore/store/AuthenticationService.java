package com.grocerystore.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    public UserInfo registorUser(AuthenticationRequest aRequest) {
        UserInfo user = new UserInfo(aRequest.getName(), aRequest.getPassword(), aRequest.getEmail(),"admin",aRequest.getBusinessname());
        System.out.println(user);
        System.out.println(user.getUsername()+" "+user.getRole()+" "+user.getEmail()+
        " "+user.getPassword()+" "+user.getBusinessName());
        return userRepository.save(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        UserInfo user = userRepository.findByUsername(authenticationRequest.getName());
        System.out.println(user);
        if (user != null && authenticationRequest.getPassword().trim().equals(user.getPassword().trim())) {
            return new AuthenticationResponse(true, "Authentication successful", user.getRole(), user.getUsername());
        } else {
            return new AuthenticationResponse(false, "Authentication failed", null, null);
        }
    }

    public void addNewUser(UserInfo userInfo){
          userRepository.save(userInfo);
    }
    @Transactional
    public void deleteUser(String name, String businessName){
           userRepository.deleteByUsernameAndBusinessName(name, businessName);
    }

    public List<UserInfo> getAllUserInfo() {
        userRepository.findAll().forEach(user -> System.out.println(user.
        toString()));
        return userRepository.findAll();
    }
}
package com.grocerystore.store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    UserSchemaRepository userSchemaRepository;

    @PostMapping("/authentication")
    public AuthenticationResponse authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(authenticationRequest);
        String schemaName = authenticationRequest.getBusinessname().replace(" ", "_");
        System.out.println(schemaName);
        userSchemaRepository.activateUserSchema(schemaName);
        return authenticationResponse;
    }
    @PostMapping("/registor")
    public ResponseEntity<?> registor(@RequestBody AuthenticationRequest authenticationRequest) {
        System.out.println("registor");
        if (authenticationService.registorUser(authenticationRequest) != null) {
            String schemaName = authenticationRequest.getBusinessname().replace(" ", "_");
            System.out.println(schemaName);
            userSchemaRepository.initializeSchema(schemaName);
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.ok(false);
        }
    }
}


package com.grocerystore.store;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class AuthenticationResponse {
    public AuthenticationResponse(boolean authenticated, String message, String userRole, String name) {
        this.authenticated = authenticated;
        this.message = message;
        this.userRole = userRole;
        this.name = name;
    }
    private boolean authenticated;
    private String message;
    private String userRole;
    private String name;
}

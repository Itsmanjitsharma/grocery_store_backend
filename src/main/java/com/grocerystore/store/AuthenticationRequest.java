package com.grocerystore.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
    private String name;
    private String password;
    private String email;
    private String businessname;
}

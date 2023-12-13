package com.grocerystore.store;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user_info" , schema="public")
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "role")
    private String role;
    @Column(name = "businessname")
    private String businessName;

    public UserInfo(String username, String password, String email, String role, String businessName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.businessName = businessName;
    }

}

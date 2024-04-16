package org.launchcode.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User extends AbstractEntity{


    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @Email
    private String email;

    public User(){

    }

    public User(String username, String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }


//    public User(String username, String email, String password, String verifyPassword) {
//        this();
//        this.username = username;
//        this.email = email;
//        this.password = password;
//        this.verifyPassword = verifyPassword;
//    }

    public String getUsername() {
        return username;
    }


    public String getEmail() {
        return email;
    }

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }


}

package org.launchcode.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {


    @Size(min = 5, max = 15, message = "Username must be between 5-15 characters long")
    @NotNull(message = "Username is required.")
    private String username;

    @NotNull(message = "Password is required")
    @Size(min = 6, max = 15, message = "Password must be 6 characters long")
    private String pwHash;

    @Email
    private String email;


    @NotNull(message = "Passwords do not match AT ALL")
    @Size(min = 6, max = 15)
    private String verifyPassword;

    public User(){

    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
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

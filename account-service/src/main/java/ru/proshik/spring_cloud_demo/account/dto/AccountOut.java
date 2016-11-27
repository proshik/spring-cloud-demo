package ru.proshik.spring_cloud_demo.account.dto;

/**
 * Created by proshik on 27.11.16.
 */
public class AccountOut {

    private String username;
    private String email;

    public AccountOut() {
    }

    public AccountOut(String username,
                      String email) {
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
}

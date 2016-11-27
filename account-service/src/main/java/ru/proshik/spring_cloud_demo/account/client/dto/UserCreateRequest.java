package ru.proshik.spring_cloud_demo.account.client.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by proshik on 27.11.16.
 */
public class UserCreateRequest {

    @NotNull
    @Length(min = 3, max = 20)
    private final String username;

    @NotNull
    @Length(min = 6, max = 40)
    private final String password;

    public UserCreateRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

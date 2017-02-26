package ru.proshik.thinkclearly.account.dto;

/**
 * Created by proshik on 27.11.16.
 */
public class AccountShortResponse {

    private String username;
    private String firstName;
    private String lastName;
    private String email;

    public AccountShortResponse() {
    }

    public AccountShortResponse(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

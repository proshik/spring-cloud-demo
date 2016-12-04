package ru.proshik.spring_cloud_demo.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by proshik on 20.11.16.
 */
@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "username", updatable = false, nullable = false, unique = true)
    private String username;

    @Column(name = "created_date", updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "confirm_email")
    private Boolean confirmEmail = Boolean.TRUE;

    public Account() {
    }

    public Account(LocalDateTime createdDate, String username, String firstName, String lastName, String email) {
        this.username = username;
        this.createdDate = createdDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getConfirmEmail() {
        return confirmEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

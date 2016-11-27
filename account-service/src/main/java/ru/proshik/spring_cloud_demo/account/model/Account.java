package ru.proshik.spring_cloud_demo.account.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Collection;

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

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "confirm_email")
    private Boolean confirmEmail = Boolean.TRUE;

    public Account() {
    }

    public Account(LocalDateTime createdDate, String username, String email) {
        this.createdDate = createdDate;
        this.username = username;
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
}

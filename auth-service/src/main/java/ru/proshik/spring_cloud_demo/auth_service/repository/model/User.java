package ru.proshik.spring_cloud_demo.auth_service.repository.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by proshik on 25.07.16.
 */
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @Column(name = "username", updatable = false, nullable = false, unique = true)
    private String username;

    @Column(name = "created_date", updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled = Boolean.TRUE;

    public User() {
    }

    public User(LocalDateTime createdDate, String username, String password) {
        this.createdDate = createdDate;
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

}

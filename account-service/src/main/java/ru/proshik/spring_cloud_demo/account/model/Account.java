package ru.proshik.spring_cloud_demo.account.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

/**
 * Created by proshik on 20.11.16.
 */
@Entity
@Table(name = "account")
public class Account implements UserDetails {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
//    @GenericGenerator(
//            name = "account_seq",
//            strategy = "enhanced-sequence",
//            parameters = @org.hibernate.annotations.Parameter(
//                    name = SequenceStyleGenerator.SEQUENCE_PARAM,
//                    value = "account_seq"))
//    private Long id;

    @Id
    @Column(name = "username", updatable = false, nullable = false, unique = true)
    private String username;

    @Column(name = "created_date", updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "password", nullable = false)
    private String password;

    public Account() {
    }

    public Account(LocalDateTime createdDate, String username, String password) {
        this.createdDate = createdDate;
        this.username = username;
        this.password = password;
    }

//    public Long getId() {
//        return id;
//    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }
}

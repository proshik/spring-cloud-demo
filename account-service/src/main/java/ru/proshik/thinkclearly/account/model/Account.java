package ru.proshik.thinkclearly.account.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static org.hibernate.id.enhanced.SequenceStyleGenerator.SEQUENCE_PARAM;

/**
 * Created by proshik on 20.11.16.
 */
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @GenericGenerator(
            name = "account_seq",
            strategy = "enhanced-sequence",
            parameters = @org.hibernate.annotations.Parameter(name = SEQUENCE_PARAM, value = "account_seq"))
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "confirm_email")
    private Boolean confirmEmail = Boolean.FALSE;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

//    @OneToOne
//    @JoinColumn(name = "users_id")
//    private User user;

    public Account() {
    }

    public Account(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
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

    public void setConfirmEmail(Boolean confirmEmail) {
        this.confirmEmail = confirmEmail;
    }
}

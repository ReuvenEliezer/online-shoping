package com.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "account")
    private Account account;

    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    protected User() {
        // for JPA
    }

    public User(String name, Account account, String email) {
        this.name = name;
        this.account = account;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                '}';
    }
}

package ru.proshik.spring_cloud_demo.account.service;


import java.security.Principal;

/**
 * Created by proshik on 23.11.16.
 */
public interface AccountService {

    void create(String username, String password);

    Principal getAccount(String username);
}

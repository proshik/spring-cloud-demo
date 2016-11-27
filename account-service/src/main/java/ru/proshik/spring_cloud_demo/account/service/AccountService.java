package ru.proshik.spring_cloud_demo.account.service;


import ru.proshik.spring_cloud_demo.account.dto.AccountOut;

/**
 * Created by proshik on 23.11.16.
 */
public interface AccountService {

    void create(String username, String email, String password, String confirmPassword);

    AccountOut getAccount(String username);
}

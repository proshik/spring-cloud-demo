package ru.proshik.spring_cloud_demo.account.service;

import ru.proshik.spring_cloud_demo.account.dto.AccountOut;
import ru.proshik.spring_cloud_demo.account.dto.AccountRegistrationIn;

/**
 * Created by proshik on 23.11.16.
 */
public interface AccountService {

    void create(AccountRegistrationIn registrationAccount);

    AccountOut getAccount(String username);
}

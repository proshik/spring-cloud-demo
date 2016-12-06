package ru.proshik.thinkclearly.account.service;

import ru.proshik.thinkclearly.account.dto.AccountOut;
import ru.proshik.thinkclearly.account.dto.AccountRegistrationIn;

/**
 * Created by proshik on 23.11.16.
 */
public interface AccountService {

    void create(AccountRegistrationIn registrationAccount);

    AccountOut getAccount(String username);
}

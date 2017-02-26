package ru.proshik.thinkclearly.account.service;

import ru.proshik.thinkclearly.account.dto.AccountShortResponse;
import ru.proshik.thinkclearly.account.dto.AccountRegistrationRequest;

/**
 * Created by proshik on 27.11.16.
 */
public interface UserService {

    AccountShortResponse loadAccountInfo(String username);

    void createUser(AccountRegistrationRequest userDto);

}

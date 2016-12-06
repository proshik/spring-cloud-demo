package ru.proshik.thinkclearly.auth_service.service;

import ru.proshik.thinkclearly.auth_service.dto.UserRequestCreate;

/**
 * Created by proshik on 27.11.16.
 */
public interface UserService {

    void createUser(UserRequestCreate userDto);

}

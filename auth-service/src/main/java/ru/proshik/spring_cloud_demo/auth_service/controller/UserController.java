package ru.proshik.spring_cloud_demo.auth_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.proshik.spring_cloud_demo.auth_service.dto.UserRequestCreate;
import ru.proshik.spring_cloud_demo.auth_service.service.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // TODO: 01.12.16 maybe need added @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }

//    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody UserRequestCreate user) {
        userService.createUser(user);
    }

}

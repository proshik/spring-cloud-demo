package ru.proshik.spring_cloud_demo.account.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.proshik.spring_cloud_demo.account.dto.AccountOut;
import ru.proshik.spring_cloud_demo.account.dto.RegistrationRequest;
import ru.proshik.spring_cloud_demo.account.service.AccountService;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by proshik on 04.10.16.
 */
@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @HystrixCommand
    @RequestMapping(method = RequestMethod.GET)
    public AccountOut getAccount(@AuthenticationPrincipal Principal principal) {
        return accountService.getAccount(principal.getName());
    }

    @HystrixCommand
    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody RegistrationRequest body) {
        accountService.create(body.getUsername(), body.getEmail(), body.getPassword(), body.getConfirmPassword());
    }
}

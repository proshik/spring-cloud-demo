package ru.proshik.spring_cloud_demo.account.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.proshik.spring_cloud_demo.account.dto.RegistrationRequest;
import ru.proshik.spring_cloud_demo.account.model.ResourceOut;
import ru.proshik.spring_cloud_demo.account.service.AccountService;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by proshik on 04.10.16.
 */
@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Deprecated
    @GetMapping
    @HystrixCommand
    public ResponseEntity getAccount() {
        return ResponseEntity.ok(new ResourceOut("anyKey", "value"));
    }

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "{username}", method = RequestMethod.GET)
    public Principal getAccount(@PathVariable(value = "username") String username) {
        return accountService.getAccount(username);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody RegistrationRequest body) {
        accountService.create(body.getUsername(), body.getPassword());
    }
}

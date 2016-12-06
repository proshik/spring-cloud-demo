package ru.proshik.thinkclearly.account.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.proshik.thinkclearly.account.dto.AccountOut;
import ru.proshik.thinkclearly.account.dto.AccountRegistrationIn;
import ru.proshik.thinkclearly.account.exception.AccountAlreadyExistsException;
import ru.proshik.thinkclearly.account.exception.PasswordNotEqualstConfirmPasswordException;
import ru.proshik.thinkclearly.account.service.AccountService;

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
    public void createUser(@Valid @RequestBody AccountRegistrationIn body) {
        validate(body);
        accountService.create(body);
    }

    @ExceptionHandler(AccountAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Account already exists")
    public void accountAlreadyExistsExceptionHandler() {
    }


    @ExceptionHandler(RetryableException.class)
    @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT, reason = "Password  validate error")
    public void passwordNotEqualsConfirmPasswordExceptionHandler() {
    }

    private void validate(AccountRegistrationIn body) {
        if (!body.getPassword().equals(body.getConfirmPassword())) {
            throw new PasswordNotEqualstConfirmPasswordException("Password not equals confirm password value");
        }
    }
}

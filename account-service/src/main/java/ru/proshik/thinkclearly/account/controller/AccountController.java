package ru.proshik.thinkclearly.account.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.proshik.thinkclearly.account.dto.AccountRegistrationRequest;
import ru.proshik.thinkclearly.account.dto.AccountShortResponse;
import ru.proshik.thinkclearly.account.exception.AccountAlreadyExistsException;
import ru.proshik.thinkclearly.account.exception.PasswordNotEqualsConfirmPasswordException;
import ru.proshik.thinkclearly.account.service.UserServiceImpl;

import javax.validation.Valid;
import java.security.Principal;

/**
 * Created by proshik on 04.10.16.
 */
@RestController
@RequestMapping("/v1/account")
public class AccountController {

    @Autowired
    private UserServiceImpl userService;

    @HystrixCommand
    @RequestMapping(method = RequestMethod.GET)
    public AccountShortResponse getAccount(@AuthenticationPrincipal Principal principal) {
        return userService.loadAccountInfo(principal.getName());
    }

    @HystrixCommand
    @RequestMapping(method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody AccountRegistrationRequest body) {
        validate(body);
        userService.createUser(body);
    }

    @ExceptionHandler(AccountAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Account already exists")
    public void accountAlreadyExistsExceptionHandler() {
    }


    @ExceptionHandler(RetryableException.class)
    @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT, reason = "Password  validate error")
    public void passwordNotEqualsConfirmPasswordExceptionHandler() {
    }

    private void validate(AccountRegistrationRequest body) {
        if (!body.getPassword().equals(body.getConfirmPassword())) {
            throw new PasswordNotEqualsConfirmPasswordException("Password not equals confirm password value");
        }
    }
}

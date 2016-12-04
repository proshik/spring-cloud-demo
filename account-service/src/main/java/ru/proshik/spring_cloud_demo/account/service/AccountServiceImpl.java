package ru.proshik.spring_cloud_demo.account.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.proshik.spring_cloud_demo.account.client.AuthClient;
import ru.proshik.spring_cloud_demo.account.client.dto.UserCreateRequest;
import ru.proshik.spring_cloud_demo.account.dto.AccountOut;
import ru.proshik.spring_cloud_demo.account.dto.AccountRegistrationIn;
import ru.proshik.spring_cloud_demo.account.exception.AccountAlreadyExistsException;
import ru.proshik.spring_cloud_demo.account.model.Account;
import ru.proshik.spring_cloud_demo.account.repository.AccountRepository;

import java.time.LocalDateTime;

/**
 * Created by proshik on 23.11.16.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthClient authClient;

    @Autowired
    private AccountRepository repository;

    @Override
    @Transactional
    public void create(AccountRegistrationIn in) {

        Account account = repository.findByUsername(in.getUsername());

        if (account != null) {
            throw new AccountAlreadyExistsException("Account with username=" + in.getUsername()
                    + " already exists");
        }

        // TODO: 27.11.16 need handle answer
        authClient.createUser(new UserCreateRequest(in.getUsername(),
                in.getPassword()));
        repository.save(new Account(LocalDateTime.now(), in.getUsername(), in.getFirstName(), in.getLastName(),
                in.getEmail()));

        log.info("New user has been created: {}", in.getUsername());
    }

    @Override
    public AccountOut getAccount(String username) {
        Account account = repository.findByUsername(username);

        if (account == null) {
            throw new IllegalArgumentException("Account with username=" + username + " not found");
        }

        return new AccountOut(account.getUsername(), account.getEmail(), account.getFirstName(), account.getLastName());
    }
}

package ru.proshik.spring_cloud_demo.account.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.proshik.spring_cloud_demo.account.client.AuthClient;
import ru.proshik.spring_cloud_demo.account.dto.AccountOut;
import ru.proshik.spring_cloud_demo.account.client.dto.UserCreateRequest;
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
    public void create(String username, String email, String password, String configPassword) {

        Account account = repository.findByUsername(username);

        if (account != null) {
            throw new IllegalArgumentException("Account with username=" + username + " already exists");
        }

        if (!password.equals(configPassword)) {
            throw new IllegalArgumentException("Password not equals confirm password value");
        }

        // TODO: 27.11.16 need handle answer
        authClient.createUser(new UserCreateRequest(username, password));

        repository.save(new Account(LocalDateTime.now(), username, email));

        log.info("new user has been created: {}", username);
    }

    @Override
    public AccountOut getAccount(String username) {
        Account account = repository.findByUsername(username);

        if (account == null) {
            throw new IllegalArgumentException("Account with username=" + username + " not found");
        }

        return new AccountOut(account.getUsername(), account.getEmail());
    }
}

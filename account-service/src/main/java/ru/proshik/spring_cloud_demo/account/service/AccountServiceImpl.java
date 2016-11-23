package ru.proshik.spring_cloud_demo.account.service;

import com.sun.security.auth.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.proshik.spring_cloud_demo.account.model.Account;
import ru.proshik.spring_cloud_demo.account.repository.AccountRepository;

import java.security.Principal;
import java.time.LocalDateTime;

/**
 * Created by proshik on 23.11.16.
 */
@Service
public class AccountServiceImpl implements AccountService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private AccountRepository repository;

    @Override
    public void create(String username, String password) {

        Account findUser = repository.findByUsername(username);

        Assert.isNull(findUser, "user already exists: " + username);

        repository.save(new Account(LocalDateTime.now(), username, encoder.encode(password)));

        log.info("new user has been created: {}", username);
    }

    @Override
    public Principal getAccount(String username) {
        Account account = repository.findByUsername(username);

        Assert.notNull(account, "account not found: " + username);

        return new UsernamePasswordAuthenticationToken(account, null);
    }
}

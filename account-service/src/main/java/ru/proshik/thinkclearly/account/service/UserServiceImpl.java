package ru.proshik.thinkclearly.account.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import ru.proshik.thinkclearly.account.dto.AccountRegistrationRequest;
import ru.proshik.thinkclearly.account.dto.AccountShortResponse;
import ru.proshik.thinkclearly.account.model.Account;
import ru.proshik.thinkclearly.account.model.User;
import ru.proshik.thinkclearly.account.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repository.findByUsername(username);

        if (user == null || !user.getAccount().getConfirmEmail()) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }

    @Override
    public AccountShortResponse loadAccountInfo(String username) {
        User user = repository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AccountShortResponse(user.getUsername(), user.getAccount().getFirstName(), user.getAccount().getLastName(),
                user.getAccount().getEmail());
    }

    @Override
    @Transactional
    public void createUser(AccountRegistrationRequest userDto) {

        User findUser = repository.findByUsername(userDto.getUsername());

        Assert.isNull(findUser, "user already exists: " + userDto.getUsername());

        Account account = new Account(userDto.getEmail(), userDto.getFirstName(), userDto.getLastName());

        String passwordHash = encoder.encode(userDto.getPassword());

        repository.save(new User(LocalDateTime.now(), userDto.getUsername(), passwordHash, account));

        log.info("new user has been created: {}", userDto.getUsername());
    }

}

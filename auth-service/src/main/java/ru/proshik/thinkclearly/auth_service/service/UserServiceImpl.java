package ru.proshik.thinkclearly.auth_service.service;

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
import ru.proshik.thinkclearly.auth_service.dto.UserRequestCreate;
import ru.proshik.thinkclearly.auth_service.repository.UserRepository;
import ru.proshik.thinkclearly.auth_service.repository.model.User;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return user;
    }

    @Override
    @Transactional
    public void createUser(UserRequestCreate userDto) {

        User findUser = repository.findByUsername(userDto.getUsername());

        Assert.isNull(findUser, "user already exists: " + userDto.getUsername());

        String passwordHash = encoder.encode(userDto.getPassword());

        repository.save(new User(LocalDateTime.now(), userDto.getUsername(), passwordHash));

        log.info("new user has been created: {}", userDto.getUsername());
    }

}

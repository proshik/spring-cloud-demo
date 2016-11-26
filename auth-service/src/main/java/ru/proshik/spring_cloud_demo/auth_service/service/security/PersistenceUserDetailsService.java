package ru.proshik.spring_cloud_demo.auth_service.service.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersistenceUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

//        UserDetails user = repository.findByUsername(username);

//        if (user == null) {
//            throw new UsernameNotFoundException(username);
//        }



        return new UserDetails() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return null;
            }

            @Override
            public String getPassword() {
                return "$2a$10$Rrq33l9mDA2yfykk4CTkTOumQYvWY731EQQA4ckw6iBB3Tcw.gfKy";
            }

            @Override
            public String getUsername() {
                return "proshik";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
    }
}

package ru.bmstu.tp_7.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Для теста возвращаем простого пользователя
        if ("user".equals(username)) {
            return User.withUsername("user")
                    .password("{noop}password") // {noop} означает, что пароль не закодирован
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User " + username + " not found");
        }
    }
}
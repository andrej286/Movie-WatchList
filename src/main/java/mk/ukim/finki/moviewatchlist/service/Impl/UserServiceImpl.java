package mk.ukim.finki.moviewatchlist.service.Impl;

import mk.ukim.finki.moviewatchlist.model.User;
import mk.ukim.finki.moviewatchlist.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        return null;
    }
}

package mk.ukim.finki.moviewatchlist.service;

import mk.ukim.finki.moviewatchlist.model.User;

public interface UserService {

    User register(String username, String password, String repeatPassword, String name, String surname);

}
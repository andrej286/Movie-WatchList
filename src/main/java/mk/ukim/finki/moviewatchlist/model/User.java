package mk.ukim.finki.moviewatchlist.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "movie_users")
public class User {

    @Id
    private String username;

    private String password;

    private String name;

    private String surname;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<WatchList> watchLists;

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }
}
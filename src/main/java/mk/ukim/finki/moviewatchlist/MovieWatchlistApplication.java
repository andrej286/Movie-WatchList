package mk.ukim.finki.moviewatchlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MovieWatchlistApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieWatchlistApplication.class, args);
    }

}

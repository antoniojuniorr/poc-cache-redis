package io.github.antoniojuniorr.poccacheredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PocCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocCacheRedisApplication.class, args);
    }

}

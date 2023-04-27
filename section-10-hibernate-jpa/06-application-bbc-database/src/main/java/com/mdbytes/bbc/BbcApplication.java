package com.mdbytes.bbc;

import com.mdbytes.bbc.utils.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbcApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserUtils userUtils, ProductUtils productUtils, StoreUtils storeUtils, AlertUtils alertUtils, SystemUtils systemUtils) {
        return runner -> {

            // All tests passed 2023.04.23

            // Drop and recreate schema.  Run and test each phase separately.
            // Phase 1: create and retrieve
            // userUtils.createManyGetAll();
            // storeUtils.createManyGetAll();
            // productUtils.createManyGetAll();
            // alertUtils.createManyGetAll();
            // systemUtils.createManyGetAll();

            // Phase 2: Update one
            // userUtils.updateOne();
            // storeUtils.updateOne();
            // productUtils.updateOne();
            // alertUtils.updateOne();
            // systemUtils.updateOne();

            // Phase 3: Delete one
            // userUtils.deleteOne();
            // storeUtils.deleteOne();
            // productUtils.deleteOne();
            // alertUtils.deleteOne();
            // systemUtils.deleteOne();

            // Phase 4: Delete all
            // userUtils.deleteAll();
            // storeUtils.deleteAll();
            // productUtils.deleteAll();
            // alertUtils.deleteAll();
            // systemUtils.deleteAll();

        };
    }
}

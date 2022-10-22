package com.dario.ift;

import com.dario.ift.config.OracleTnsConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .listeners(new OracleTnsConfig())
                .run(args);
    }

}

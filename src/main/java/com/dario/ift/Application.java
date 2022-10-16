package com.dario.ift;

import com.dario.ift.config.OracleTnsConfig;
import com.dario.ift.core.domain.Dog;
import com.dario.ift.core.repository.DogRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.annotation.Resource;
import java.util.Optional;

@SpringBootApplication
@Slf4j
public class Application {

    @Resource
    private DogRepository dogRepository;

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .listeners(new OracleTnsConfig())
                .run(args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void peekDb() {
        Dog ichiro = dogRepository.getFamilyTree();
        // TODO create all dogs in DB here?

        Optional<Dog> dog = dogRepository.findByName("Ichiro Go Takimisou");
        log.info("Dog: {}", dog.orElseGet(() -> Dog.builder().build()));
    }

}

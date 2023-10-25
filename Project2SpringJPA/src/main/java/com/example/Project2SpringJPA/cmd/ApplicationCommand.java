package com.example.Project2SpringJPA.cmd;

import com.example.Project2SpringJPA.slope.service.api.SlopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

/**
 * Component for interaction with user using command line. Components annotated with {@link @Component} implementing
 * {@link CommandLineRunner} are executed automatically..
 */
@Component
public class ApplicationCommand implements CommandLineRunner {

    /**
     * Service for managing slopes. Should be injected automatically.
     */
    private final SlopeService slopeService;

    /**
     * @param slopeService service accessing slopes
     */
    @Autowired
    public ApplicationCommand(SlopeService slopeService) {
        this.slopeService = slopeService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "delete_slope" -> {
                    try {
                        UUID uuid = UUID.fromString(scanner.next());
                        slopeService.delete(uuid);
                    } catch (NoSuchElementException ex) {
                        System.out.println("Not Found");
                    }
                }
                case "echo" -> {
                    System.out.println("echo echo echo");
                }
            }
        }
    }


}

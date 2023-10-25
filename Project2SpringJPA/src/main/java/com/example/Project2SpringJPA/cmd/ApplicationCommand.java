package com.example.Project2SpringJPA.cmd;

import com.example.Project2SpringJPA.slope.entity.SkiResort;
import com.example.Project2SpringJPA.slope.entity.Slope;
import com.example.Project2SpringJPA.slope.service.api.SkiResortService;
import com.example.Project2SpringJPA.slope.service.api.SlopeService;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;
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
    private final SkiResortService skiResortService;

    /**
     * @param slopeService     service accessing slopes
     * @param skiResortService service accessing ski resorts
     */
    @Autowired
    public ApplicationCommand(SlopeService slopeService, SkiResortService skiResortService) {
        this.slopeService = slopeService;
        this.skiResortService = skiResortService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "help" -> {
                    System.out.println("Available commands:\n" +
                            "list ski resorts" +
                            "list all slopes" +
                            "add new slope [category id] [new slope id] [name] [steepness]" +
                            "delete slope" +
                            "stop"
                    );
                }
                case "list ski resorts" -> {
                    System.out.println(skiResortService.findAll());
                }
                case "list all slopes" -> {
                    System.out.println(slopeService.findAll());
                }
                case "add new slope" -> {
                    try {
                        UUID category = UUID.fromString(scanner.next());
                        SkiResort skiResort = skiResortService.find(category).get();;
                        UUID uuid = UUID.fromString(scanner.next());
                        String name = scanner.next();
                        int steepness = Integer.parseInt(scanner.next());
                        slopeService.create(
                                Slope
                                        .builder()
                                        .id(uuid)
                                        .name(name)
                                        .steepness(steepness)
                                        .skiResort(skiResort)
                                        .build());
                    } catch (NoSuchElementException ex) {
                        System.out.println("Not Found");
                    }
                }
                case "delete slope" -> {
                    try {
                        UUID uuid = UUID.fromString(scanner.next());
                        slopeService.delete(uuid);
                    } catch (NoSuchElementException ex) {
                        System.out.println("Not Found");
                    }
                }
                case "stop" -> {
                    System.out.println("Stopping...");
                }
            }
        }
    }


}

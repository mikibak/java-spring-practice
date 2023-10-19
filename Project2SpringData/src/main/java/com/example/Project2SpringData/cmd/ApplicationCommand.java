package com.example.Project2SpringData.cmd;

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
     * @param characterController controller for accessing characters
     * @param writer              writer for JSON
     * @param imageToAnsiArt      converts image to ANSI art
     */
    //@Autowired
    public ApplicationCommand(

    ) {

    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while (true) {
            command = scanner.next();
            switch (command) {
                case "get_characters" -> {
                    System.out.println("get_characters");
                }
                case "get_character" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    try {
                        System.out.println("get_character");
                    } catch (NoSuchElementException ex) {
                        System.out.println("NOT_FOUND");
                    }
                }
                case "get_character_portrait" -> {
                    UUID uuid = UUID.fromString(scanner.next());
                    try {
                        System.out.println("get_character_portrait");
                    } catch (NoSuchElementException ex) {
                        System.out.println("NOT_FOUND");
                    }
                }
                case "delete_character" -> {
                    try {
                        System.out.println("delete_character");
                    } catch (NoSuchElementException ex) {
                        System.out.println("Not Found");
                    }
                }
                case "put_character" -> {
                    System.out.println("put_character");
                }
                case "quit" -> {
                    break main_loop;
                }
            }
        }
    }


}

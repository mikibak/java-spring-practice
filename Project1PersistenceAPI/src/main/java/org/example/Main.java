package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.modelmapper.ModelMapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("rpgPu")) {
            EntityManager em = factory.createEntityManager();
            Repository db = new Repository(em);

            //TASK 2
            Profession mage = Profession.builder().name("Mage").baseArmor(10).build();
            Profession fighter = Profession.builder().name("Fighter").baseArmor(17).build();
            db.add(mage);
            db.add(fighter);
            Character character = Character.builder().name("Magik z Paktofoniki").level(9).profession(mage).build();
            Character character1 = Character.builder().name("Harry Pot").level(420).profession(mage).build();
            Character character2 = Character.builder().name("Jaś Kapela").level(69).profession(fighter).build();
            Character character3 = Character.builder().name("Najman").level(1).profession(fighter).build();
            db.add(character);
            db.add(character1);
            db.add(character2);
            db.add(character3);
            db.getProfessionList().forEach((professionElement) -> {
                System.out.println(professionElement.toString());
                professionElement.characters.forEach((characterElement) ->
                        System.out.println("    " + characterElement.toString())
                );
            });

            //TASK 3
            List<Character> allElements = db.getProfessionList().stream()
                    .flatMap(element -> element.getCharacters().stream())
                    .toList();

            System.out.println(allElements
                    .stream()
                    .collect(Collectors.toList()));

            //TASK 4
            System.out.println(allElements
                    .stream()
                    .filter(element -> element.getName().length() > 5)
                    .sorted(Comparator.comparingInt(Character::getLevel))
                    .collect(Collectors.toList()));

            //TASK 5
            ModelMapper modelMapper = new ModelMapper();
            List<CharacterDto> charactersDto = allElements
                    .stream()
                    .map(objects -> new CharacterDto(objects.getName(), objects.getLevel(), objects.getProfession().getName()))
                    .collect(Collectors.toList());
            System.out.println("List of character DTOs: " + charactersDto);

            //TASK 6
            List<Profession> professions = new ArrayList<>();
            professions.add(mage);
            professions.add(fighter);
            String filename = "filename";
            // save the object to file
            FileOutputStream fos = null;
            ObjectOutputStream out = null;
            try {
                fos = new FileOutputStream(filename);
                out = new ObjectOutputStream(fos);
                out.writeObject(professions);

                out.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            // read the object from file
            // save the object to file
            FileInputStream fis = null;
            ObjectInputStream in = null;
            try {
                fis = new FileInputStream(filename);
                in = new ObjectInputStream(fis);
                List<Profession> loadedProfessions = (List<Profession>) in.readObject();
                System.out.println("Loaded list: " + loadedProfessions);
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //TASK 7

            int customThreadPoolSize = 1; // Adjust the pool size as needed

            ForkJoinPool customThreadPool = new ForkJoinPool(customThreadPoolSize);

            professions.parallelStream()
                    .forEach(profession -> customThreadPool
                            .execute(() -> {
                                        try {
                                            Thread.sleep(2000);
                                            profession.characters.forEach(System.out::println);
                                        } catch (InterruptedException e) {
                                            throw new RuntimeException(e);
                                        }
                                    }
                            )
                    );

            // Gracefully close the custom thread pool
            customThreadPool.shutdown();
            try {
                customThreadPool.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            em.close();
        }
    }
}
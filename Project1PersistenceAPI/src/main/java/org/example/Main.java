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
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace slopes in your code.
public class Main {
    public static void main(String[] args) {

        try (EntityManagerFactory factory = Persistence.createEntityManagerFactory("rpgPu")) {
            EntityManager em = factory.createEntityManager();
            Repository db = new Repository(em);

            //TASK 2
            System.out.println("\nTASK 2");
            SkiResort mage = SkiResort.builder().name("Mage").baseArmor(10).build();
            SkiResort fighter = SkiResort.builder().name("Fighter").baseArmor(17).build();
            SkiResort cleric = SkiResort.builder().name("Cleric").baseArmor(15).build();
            db.add(mage);
            db.add(fighter);
            db.add(cleric);
            db.add(Slope.builder().name("Magik z Paktofoniki").level(9).skiResort(mage).build());
            db.add(Slope.builder().name("Harry Pot").level(420).skiResort(mage).build());
            db.add(Slope.builder().name("Kubale").level(100).skiResort(mage).build());
            db.add(Slope.builder().name("Jaś Kapela").level(69).skiResort(fighter).build());
            db.add(Slope.builder().name("Najman").level(1).skiResort(fighter).build());
            db.add(Slope.builder().name("Kuna").level(100).skiResort(cleric).build());
            db.add(Slope.builder().name("Manus").level(1000).skiResort(cleric).build());
            db.getProfessionList().forEach((skiResortElement) -> {
                System.out.println(skiResortElement.toString());
                skiResortElement.slopes.forEach((slopeElement) ->
                        System.out.println("    " + slopeElement.toString())
                );
            });

            //TASK 3
            System.out.println("\nTASK 3");
            Set<Slope> allElements = db.getProfessionList().stream()
                    .flatMap(element -> element.getSlopes().stream())
                    .collect(Collectors.toSet());

            allElements
                    .forEach(System.out::println);

            //TASK 4
            System.out.println("\nTASK 4");
            System.out.println(allElements
                    .stream()
                    .filter(element -> element.getName().length() > 5)
                    .sorted(Comparator.comparingInt(Slope::getLevel))
                    .collect(Collectors.toList()));

            //TASK 5
            System.out.println("\nTASK 5");
            ModelMapper modelMapper = new ModelMapper();
            List<CharacterDto> charactersDto = allElements
                    .stream()
                    .map(objects -> new CharacterDto(objects.getName(), objects.getLevel(), objects.getSkiResort().getName()))
                    .collect(Collectors.toList());
            System.out.println("List of character DTOs: " + charactersDto);

            //TASK 6
            System.out.println("\nTASK 6");
            List<SkiResort> skiResorts = new ArrayList<>();
            skiResorts.add(mage);
            skiResorts.add(fighter);
            skiResorts.add(cleric);
            String filename = "filename";
            // save the object to file
            FileOutputStream fos = null;
            ObjectOutputStream out = null;
            try {
                fos = new FileOutputStream(filename);
                out = new ObjectOutputStream(fos);
                out.writeObject(skiResorts);

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
                List<SkiResort> loadedSkiResorts = (List<SkiResort>) in.readObject();
                System.out.println("Loaded list: " + loadedSkiResorts);
                in.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //TASK 7

            System.out.println("\nTASK 7");
            System.out.println("2 thread");
            ForkJoinPool customThreadPool = new ForkJoinPool(1);
            skiResorts.parallelStream()
                    .forEach(skiResort -> customThreadPool
                            .execute(() -> {
                                skiResort.slopes.forEach(element -> {
                                    try {
                                        Thread.sleep(2000);
                                        System.out.println(element);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                });
                            })
                    );
            customThreadPool.awaitQuiescence(10, TimeUnit.SECONDS);
            customThreadPool.shutdown();

            System.out.println("3 threads");
            ForkJoinPool customThreadPool1 = new ForkJoinPool(2);
            skiResorts.parallelStream()
                    .forEach(skiResort -> customThreadPool1
                            .execute(() -> {
                                skiResort.slopes.forEach(element -> {
                                    try {
                                        Thread.sleep(2000);
                                        System.out.println(element);
                                    } catch (InterruptedException e) {
                                        throw new RuntimeException(e);
                                    }
                                });
                            })
                    );
            customThreadPool1.awaitQuiescence(10, TimeUnit.SECONDS);
            customThreadPool1.shutdown();

            em.close();
        }
    }
}
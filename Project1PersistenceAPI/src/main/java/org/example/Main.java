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

            //TASK 1
            //Implementation of entity classes with appropriate comparison mechanisms (based
            //on both hash and natural ordering) and text representation. Be careful about
            //circuital dependencies. For element class additional implement DTO class with
            //original fields but instead whole category use only one category field (the one best
            //identifying it). For object creation builder pattern should be used. When some task
            //requires to print object, the text representation should be used.

            //TASK 2
            //At the application start-up, collection of categories filled with elements (remember
            //about two way relationships) should be created. At this moment there is no need for
            //user interaction. Objects should be created in code using appropriate creation
            //methods. Then using nested for each lambda print all categories and elements in
            //original order.
            System.out.println("\nTASK 2");
            SkiResort Monterosa = SkiResort.builder().name("Monterosa").visitors(10000).build();
            SkiResort SappeyEnChartreuse = SkiResort.builder().name("Sappey-en-Chartreuse").visitors(1700).build();
            SkiResort Wiezyca = SkiResort.builder().name("Wieżyca").visitors(150).build();

            db.add(Monterosa);
            db.add(SappeyEnChartreuse);
            db.add(Wiezyca);

            db.add(Slope.builder().name("Gressoney").steepness(9).skiResort(Monterosa).build());
            db.add(Slope.builder().name("Champorcher").steepness(12).skiResort(Monterosa).build());
            db.add(Slope.builder().name("Balma").steepness(16).skiResort(Monterosa).build());

            db.add(Slope.builder().name("Le Trat").steepness(1).skiResort(SappeyEnChartreuse).build());
            db.add(Slope.builder().name("Baby").steepness(12).skiResort(SappeyEnChartreuse).build());
            db.add(Slope.builder().name("La Combe").steepness(21).skiResort(SappeyEnChartreuse).build());
            db.add(Slope.builder().name("La Palle").steepness(40).skiResort(SappeyEnChartreuse).build());

            db.add(Slope.builder().name("Kotlinka").steepness(12).skiResort(Wiezyca).build());
            db.add(Slope.builder().name("Misiowa Górka").steepness(2).skiResort(Wiezyca).build());
            db.add(Slope.builder().name("Koszałkowy Wierch").steepness(30).skiResort(Wiezyca).build());

            db.getSkiResortList().forEach((skiResortElement) -> {
                System.out.println(skiResortElement.toString());
                skiResortElement.slopes.forEach((slopeElement) ->
                        System.out.println("    " + slopeElement.toString())
                );
            });

            //TASK 3
            //Using single Stream API pipeline create Set collection all elements (from all
            //categories). Then using second pipeline print it.
            System.out.println("\nTASK 3");
            Set<Slope> allElements = db.getSkiResortList().stream()
                    .flatMap(element -> element.getSlopes().stream())
                    .collect(Collectors.toSet());

            allElements
                    .forEach(System.out::println);

            //TASK 4
            //Using single Stream API pipeline filter elements collection created earlier (by one
            //selected property), then sort it (by one different property) and print it.
            System.out.println("\nTASK 4");
            System.out.println(allElements
                    .stream()
                    .filter(element -> element.getName().length() > 5)
                    .sorted(Comparator.comparingInt(Slope::getSteepness))
                    .collect(Collectors.toList()));

            //TASK 5
            //Using single Stream API pipeline transform elements collection created earlier into
            //steam of DTO objects, then sort them using natural order and collect them into
            //List collection. Then using second pipeline print it.
            System.out.println("\nTASK 5");
            ModelMapper modelMapper = new ModelMapper();
            List<SlopeDto> slopesDto = allElements
                    .stream()
                    .map(objects -> new SlopeDto(objects.getName(), objects.getSteepness(), objects.getSkiResort().getName()))
                    .collect(Collectors.toList());
            System.out.println("List of slope DTOs: " + slopesDto);

            //TASK 6
            //Using serialization mechanism store collection of categories in the binary file, then
            //read it from it and print call categories with elements.
            System.out.println("\nTASK 6");
            List<SkiResort> skiResorts = new ArrayList<>();
            skiResorts.add(Monterosa);
            skiResorts.add(SappeyEnChartreuse);
            skiResorts.add(Wiezyca);
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
            //Using Stream API parallel pipelines with custom thread pool execute some task on
            //each category. For example task can be printing each collection elements with
            //intervals using Thread.sleep() to simulate workload. Observer result with
            //different custom pool sizes. For thread pool use ForkJoinPool Remember about
            //closing the thread pool.
            System.out.println("\nTASK 7");

            System.out.println("3 threads");
            ForkJoinPool customThreadPool1 = new ForkJoinPool(2);
            printParallel(skiResorts, customThreadPool1);

            System.out.println("2 threads");
            ForkJoinPool customThreadPool = new ForkJoinPool(1);
            printParallel(skiResorts, customThreadPool);

            em.close();
        }
    }

    private static void printParallel(List<SkiResort> skiResorts, ForkJoinPool customThreadPool) {
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
    }
}
package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class Repository {
    private final EntityManager em;

    public Repository(EntityManager em) {
        this.em = em;
    }

    public void add(SkiResort object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public void add(Slope object) {
        SkiResort SkiResort = (SkiResort)em.find(SkiResort.class, (Object) object.getSkiResort().getName());
        em.getTransaction().begin();
        em.persist(object);
        em.refresh(SkiResort);
        em.getTransaction().commit();
    }

    public void deleteCharacter(String characterName) {
        em.getTransaction().begin();
        Slope Slope = em.find(Slope.class, characterName);
        if (Slope != null) {
            em.remove(Slope);
            System.out.println("Piwo zostało usunięte.");
        } else {
            System.out.println("Nie znaleziono piwa o podanej nazwie.");
        }

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    public void deleteProfession(String professionName) {
        em.getTransaction().begin();
        SkiResort SkiResort = em.find(SkiResort.class, professionName);
        if (SkiResort != null) {
            em.remove(SkiResort);
            System.out.println("Browar został usunięty.");
        } else {
            System.out.println("Nie znaleziono browaru o podanej nazwie.");
        }

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    public SkiResort getProfession(String name) {
        SkiResort SkiResort = (SkiResort)em.find(SkiResort.class, name);
        if(SkiResort == null) {
            System.out.println("Nie ma takiego browaru!");
        }
        return SkiResort;
    }

    public List<Slope> getCharacterList() {
        return em.createQuery("SELECT c FROM Slope c", Slope.class).getResultList();
    }

    public List<SkiResort> getProfessionList() {
        return em.createQuery("SELECT c FROM SkiResort c", SkiResort.class).getResultList();
    }
}
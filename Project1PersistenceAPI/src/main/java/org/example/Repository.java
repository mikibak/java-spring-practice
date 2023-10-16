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

    public void deleteSlope(String slopeName) {
        em.getTransaction().begin();
        Slope Slope = em.find(Slope.class, slopeName);
        if (Slope != null) {
            em.remove(Slope);
            System.out.println("Removed");
        } else {
            System.out.println("Not found");
        }

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    public void deleteSkiResort(String skiResortName) {
        em.getTransaction().begin();
        SkiResort SkiResort = em.find(SkiResort.class, skiResortName);
        if (SkiResort != null) {
            em.remove(SkiResort);
            System.out.println("Removed");
        } else {
            System.out.println("Not found");
        }

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    public SkiResort getSkiResort(String name) {
        SkiResort SkiResort = (SkiResort)em.find(SkiResort.class, name);
        if(SkiResort == null) {
            System.out.println("Not found");
        }
        return SkiResort;
    }

    public List<Slope> getSlopeList() {
        return em.createQuery("SELECT c FROM Slope c", Slope.class).getResultList();
    }

    public List<SkiResort> getSkiResortList() {
        return em.createQuery("SELECT s FROM SkiResort s", SkiResort.class).getResultList();
    }
}
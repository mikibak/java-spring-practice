package org.example;

import jakarta.persistence.EntityManager;

import java.util.List;

public class Repository {
    private final EntityManager em;

    public Repository(EntityManager em) {
        this.em = em;
    }

    public void add(Profession object) {
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
    }

    public void add(Character object) {
        Profession Profession = (Profession)em.find(Profession.class, (Object) object.getProfession().getName());
        em.getTransaction().begin();
        em.persist(object);
        em.refresh(Profession);
        em.getTransaction().commit();
    }

    public void deleteCharacter(String characterName) {
        em.getTransaction().begin();
        Character Character = em.find(Character.class, characterName);
        if (Character != null) {
            em.remove(Character);
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
        Profession Profession = em.find(Profession.class, professionName);
        if (Profession != null) {
            em.remove(Profession);
            System.out.println("Browar został usunięty.");
        } else {
            System.out.println("Nie znaleziono browaru o podanej nazwie.");
        }

        em.flush();
        em.clear();
        em.getTransaction().commit();
    }

    public Profession getProfession(String name) {
        Profession Profession = (Profession)em.find(Profession.class, name);
        if(Profession == null) {
            System.out.println("Nie ma takiego browaru!");
        }
        return Profession;
    }

    public List<Character> getCharacterList() {
        return em.createQuery("SELECT c FROM Character c", Character.class).getResultList();
    }

    public List<Profession> getProfessionList() {
        return em.createQuery("SELECT c FROM Profession c", Profession.class).getResultList();
    }
}
package com.cognizant.orm;

import com.cognizant.orm.entity.Country;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

// This application demonstrates real-world JPA / Hibernate database operations
// using an in-memory H2 database.

public class Application {

    public static void main(String[] args) {
        System.out.println("=== Starting JPA / Hibernate Demo Application ===");

        // Create EntityManagerFactory matching persistence-unit name in persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("orm-learn-pu");
        EntityManager em = emf.createEntityManager();

        try {
            // 1. Insert Countries (Create)
            em.getTransaction().begin();
            System.out.println("\nInserting new countries...");
            
            Country c1 = new Country("India");
            Country c2 = new Country("United States");
            Country c3 = new Country("Japan");
            
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            
            em.getTransaction().commit();
            System.out.println("Countries inserted successfully!");

            // 2. Fetch and Print all countries (Read)
            em.getTransaction().begin();
            List<Country> countries = em.createQuery("SELECT c FROM Country c", Country.class).getResultList();
            System.out.println("\nFetching all countries from DB:");
            for (Country country : countries) {
                System.out.println(" - " + country);
            }
            em.getTransaction().commit();

            // 3. Find a specific country by ID and update it (Update)
            em.getTransaction().begin();
            Country countryToUpdate = em.find(Country.class, 2L);
            if (countryToUpdate != null) {
                System.out.println("\nUpdating country: " + countryToUpdate.getName());
                countryToUpdate.setName("USA");
            }
            em.getTransaction().commit();

            // 4. Print after update
            em.getTransaction().begin();
            Country updatedCountry = em.find(Country.class, 2L);
            System.out.println("Updated Country: " + updatedCountry);
            em.getTransaction().commit();

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
            System.out.println("\n=== JPA / Hibernate Demo Finished ===");
        }
    }
}

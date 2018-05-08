package com.company;

import com.company.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("manager1");

        EntityManager entityManager = factory.createEntityManager();

        List<User> from_user = entityManager.createQuery("from User").getResultList();

        for (User u : from_user)
            System.out.println(u);
    }
}

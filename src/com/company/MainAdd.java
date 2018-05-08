package com.company;

import com.company.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Scanner;

public class MainAdd {
    public static void main(String[] args) {
        User user = new User();

        System.out.println("Vul je naam in");

        Scanner scanner = new Scanner(System.in);
        user.setName(scanner.nextLine());

        System.out.println("Vul je wachtwoord in");
        user.setPassword(scanner.nextLine());

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("manager1");

        EntityManager entityManager = factory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(user);
        transaction.commit();
    }
}

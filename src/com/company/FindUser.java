package com.company;

import com.company.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class FindUser {
    public static void main(String[] args) {
        User user = new User();

        System.out.println("Vul je naam in");

        Scanner scanner = new Scanner(System.in);
        user.setName(scanner.nextLine());

        System.out.println("Vul je wachtwoord in");

        user.setPassword(scanner.nextLine());
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("manager1");

        EntityManager entityManager = factory.createEntityManager();

        User u = (User) entityManager.createQuery("from User u where u.name = :username and u.password = :password")
                .setParameter("username", user.getName())
                .setParameter("password", user.getPassword())
                .getSingleResult();

        if (u != null) {
            System.out.print("User found!");
        }
    }
}

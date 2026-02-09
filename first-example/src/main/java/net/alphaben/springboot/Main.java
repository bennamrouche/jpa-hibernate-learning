package net.alphaben.springboot;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-unit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Message message = new Message();
        message.setText("Hello World!");
        em.persist(message);

        var query =     em.createQuery("select  m  from Message m"); // jpql
        List<Message> messages =  query.getResultList();

        messages.get(0).setText("Take me to your leader!");

        tx.commit();
        em.close();
    }
}
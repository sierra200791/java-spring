package com.example.market.crud;
import com.example.market.crud.SimpleItems;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.example.market.crud.SimpleItems;

import java.util.List;


public class CrudApp {
    private static SessionFactory factory;



    public static void init() {
        factory = new Configuration().configure("configs/hibernate.cfg.xml").buildSessionFactory();
    }

    public static void main(String[] args) {
        try {
            init();
//            readAndPrintSimple();
//            showAll();
//            updateItem("Ipad", 1000);
//            removeItem(5L);
            findById(4L);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            factory.close();
        }
    }

    public static void readAndPrintSimple(){
        try(Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItems simpleItems = session.get(SimpleItems.class, 1L);

            System.out.println(simpleItems.toString());
            session.getTransaction().commit();
        }
    }

    public static void showAll(){
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            List<SimpleItems> simpleItems = session.createQuery
                            ("select s from SimpleItems s").getResultList();
            System.out.println(simpleItems);
            session.getTransaction().commit();
        }
    }

        public static void findById(Long id){
            try (Session session = factory.getCurrentSession()){
                session.beginTransaction();
                List<SimpleItems> simpleItems = session.createQuery
                        ("select s from SimpleItems s where id=:id",SimpleItems.class)
                        .setParameter("id",id).getResultList();
                System.out.println(simpleItems);
                session.getTransaction().commit();
            }
    }

    public static void updateItem(String title,int price){
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            SimpleItems items = new SimpleItems();
            items.setTitle(title);
            items.setPrice(price);
            session.save(items);
            session.getTransaction().commit();
        }
    }


    public static  void  removeItem(Long id){
        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            SimpleItems items = session.get(SimpleItems.class,id);
            session.remove(items);
            session.getTransaction().commit();
        }
    }
}

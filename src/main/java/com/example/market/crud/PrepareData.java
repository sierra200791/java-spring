package com.example.market.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PrepareData {




    public static  void init(){
        SessionFactory factory = new Configuration().configure("configs/hibernate.cfg.xml").buildSessionFactory();
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
        session = factory.getCurrentSession();
        session.beginTransaction();
        session.createNativeQuery(sql).executeUpdate();
        session.getTransaction().commit();

    } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            factory.close();
        }

    }

    public static void main(String[] args) {
        init();
    }
}

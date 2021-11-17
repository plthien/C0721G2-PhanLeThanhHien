package com.codegym.repository.impl;

import com.codegym.bean.Song;
import com.codegym.repository.ISongRepository;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class SongRepositoryImpl implements ISongRepository {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    static {
        sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }

    @Override
    public List<Song> findAll() {
        return entityManager.createQuery("select s from song as s",Song.class).getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findById(Integer id) {
        return entityManager.find(Song.class,id);
    }

    @Override
    public void update(Song song) {

    }

    @Override
    public void remove(Song song) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(song);
        entityTransaction.commit();
    }
}

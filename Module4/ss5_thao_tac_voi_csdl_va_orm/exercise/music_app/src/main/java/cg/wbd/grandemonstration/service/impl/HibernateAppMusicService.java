package cg.wbd.grandemonstration.service.impl;

import cg.wbd.grandemonstration.model.AppMusic;
import cg.wbd.grandemonstration.service.IAppMusicService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Service
public class HibernateAppMusicService implements IAppMusicService {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<AppMusic> findAll() {
        String queryStr = "SELECT m FROM AppMusic AS m";
        TypedQuery<AppMusic> query = entityManager.createQuery(queryStr, AppMusic.class);
        return query.getResultList();
    }

    @Override
    public AppMusic findOne(Long id) {
        String queryStr = "SELECT m FROM AppMusic AS m WHERE m.id = :id";
        TypedQuery<AppMusic> query = entityManager.createQuery(queryStr, AppMusic.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public AppMusic save(AppMusic appMusic) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            AppMusic origin = findOne(appMusic.getId());
            origin.setName(appMusic.getName());
            origin.setNameSinger(appMusic.getNameSinger());
            origin.setKingOfMusic(appMusic.getKingOfMusic());
            origin.setLink(appMusic.getLink());
            session.saveOrUpdate(origin);
            transaction.commit();
            return origin;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public List<AppMusic> save(List<AppMusic> appMusics) {
        return null;
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<AppMusic> findAll(List<Long> id) {
        return Collections.emptyList();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(AppMusic appMusic) {

    }

    @Override
    public void delete(List<AppMusic> appMusics) {

    }

    @Override
    public void deleteAll() {

    }
}

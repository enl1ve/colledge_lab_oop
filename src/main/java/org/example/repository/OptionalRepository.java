package org.example.repository;

import org.example.dao.OptionalDao;
import org.example.entity.Optional;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class OptionalRepository implements OptionalDao {
    private final SessionFactory sessionFactory;

    public OptionalRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void update(Optional obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void save(Optional obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        //entityManager.persist(obj);
        entityManager.createNativeQuery("INSERT INTO `optionals` (`nameOptional`, `nameTeacher`, `surnameTeacher`) VALUES (?,?,?)")
                .setParameter(1, obj.getNameOptional())
                .setParameter(2, obj.getNameTeacher())
                .setParameter(3, obj.getSurnameTeacher())
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Optional obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // SQl
        entityManager
                .createNativeQuery("delete from `optionals` as c where c.id=?")
                .setParameter(1,obj.getId())
                .executeUpdate();

        // HQL
        entityManager.createQuery("delete from Optional as c where c.id=:id")
                .setParameter("id", obj.getId())
                .executeUpdate();


        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll(Optional obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        // SQl
        entityManager
                .createNativeQuery("delete from `optionals`")
                .executeUpdate();

        // HQL
        entityManager.createQuery("delete from Optional")
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Optional> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // sql
        List<Optional> optionals = entityManager.createNativeQuery("select * from `optionals`").getResultList();

        // hql
        List<Optional> optionals1 = entityManager.createQuery("select c from Optional as c", Optional.class).getResultList();


        entityManager.getTransaction().commit();
        entityManager.close();
        return optionals;
    }

    @Override
    public Optional findById(Long id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // hql
        Optional optional = entityManager
                .createQuery("select c from Optional as c where  c.id=:id", Optional.class)
                .setParameter("id", id).getSingleResult();
        //.getResultList().get(0);


        entityManager.getTransaction().commit();
        entityManager.close();
        return optional;
    }

    @Override
    public Optional findByName(String name) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Optional optional = entityManager
                .createQuery("select c from Optional as c where  c.nameOptional=:name", Optional.class)
                .setParameter("name", name)
                .getSingleResult();


        entityManager.getTransaction().commit();
        entityManager.close();
        return optional;
    }
}

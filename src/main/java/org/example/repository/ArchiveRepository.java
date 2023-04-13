package org.example.repository;

import org.example.dao.ArchiveDao;
import org.example.entity.Archive;
import org.example.entity.Optional;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class ArchiveRepository implements ArchiveDao {
    private final SessionFactory sessionFactory;

    public ArchiveRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void update(Archive obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createNativeQuery("update `archive` set rating=? where id=?")
                .setParameter(1, obj.getRating())
                .setParameter(2, obj.getId())
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void save(Archive obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // SQL
        entityManager.createNativeQuery("INSERT INTO `archive` (`rating`) VALUES (?)")
                .setParameter(1, obj.getRating())
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void delete(Archive obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Archive as p where p.id=:id")
                .setParameter("id", obj.getId())
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll(Archive obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("delete from Archive as p")
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Archive> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Archive> archive1 = entityManager.createNativeQuery("select * from `archive`").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return archive1;
    }

    @Override
    public Archive findById(Long id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Archive archive = entityManager.createQuery("select p from Archive as p where  p.id=:id", Archive.class)
                .setParameter("id", id)
                .getResultList().get(0);
        entityManager.getTransaction().commit();
        entityManager.close();
        return archive;
    }

    @Override
    public Archive findByName(String optional) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Archive archive = entityManager.createQuery("select p from Archive as p where  p.optional=:optional", Archive.class)
                .setParameter("optional", optional)
                .getResultList().get(0);
        entityManager.getTransaction().commit();
        entityManager.close();
        return archive;
    }
}

package org.example.repository;

import org.example.dao.StudentDao;
import org.example.entity.Student;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentRepository implements StudentDao {
    private final SessionFactory sessionFactory;

    public StudentRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void update(Student obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createNativeQuery("UPDATE `student` SET nameStudent=?, surnameStudent=? WHERE id=?")
                .setParameter(1, obj.getNameStudent())
                .setParameter(2, obj.getSurnameStudent())
                .setParameter(3, obj.getId())
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void save(Student obj) {

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createNativeQuery("INSERT INTO `student` (`nameStudent`, `surnameStudent`) VALUES (?,?)")
                .setParameter(1, obj.getNameStudent())
                .setParameter(2, obj.getSurnameStudent())
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public void delete(Student obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("delete from Student as p where p.id=:id")
                .setParameter("id", obj.getId())
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteAll(Student obj) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.createQuery("delete from Student as p")
                .executeUpdate();

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Student> findAll() {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        List<Student> students = entityManager.createNativeQuery("select * from `student`").getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return students;
    }

    @Override
    public Student findById(Long id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.createQuery("select p from Student as p where  p.id=:id", Student.class)
                .setParameter("id", id)
                .getResultList().get(0);

        entityManager.getTransaction().commit();
        entityManager.close();

        return student;
    }

    @Override
    public Student findByName(String surname) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Student student = entityManager.createQuery("select p from Student as p where  p.surnameStudent=:surnameStudent", Student.class)
                .setParameter("surnameStudent", surname)
                .getResultList().get(0);

        entityManager.getTransaction().commit();
        entityManager.close();

        return student;

    }
}

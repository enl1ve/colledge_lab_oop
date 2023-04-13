package org.example;

import org.example.config.Factory;
import org.example.dao.ArchiveDao;
import org.example.dao.OptionalDao;
import org.example.dao.StudentDao;
import org.example.entity.Archive;
import org.example.entity.Optional;
import org.example.entity.Student;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestHibernate  {
    private final Factory factory = Factory.getInstance();

    @Test
    public void Test1 () {
        StudentDao studentDao = factory.getStudentDao();

        Student student = new Student();

        student.setNameStudent("GG");
        student.setSurnameStudent("WP");

        studentDao.save(student);

        Student student1 = studentDao.findById(1L);

        assertEquals(1L, student1.getId().longValue());

        Student student2 = studentDao.findByName("WP");
        assertEquals(1L, student2.getId().longValue());

        List<Student> students = studentDao.findAll();
        assertEquals(1, students.size());

        student1.setNameStudent("RAmpage");
        student1.setSurnameStudent("pudge");
        studentDao.update(student1);
        Student student3 = studentDao.findByName("pudge");
        assertEquals(1L, student3.getId().longValue());




        OptionalDao optionalDao = factory.getOptionalDao();

        Optional optional = new Optional();
        optional.setNameOptional("DOTA");
        optional.setNameTeacher("Petya");
        optional.setSurnameTeacher("Pudge");
        optional.setStudent(student);

        optionalDao.save(optional);

        List<Optional> optionals = optionalDao.findAll();

        assertEquals(1,optionals.size());

        Optional optional1 = optionalDao.findById(1L);

        assertEquals("DOTA", optional1.getNameOptional());

        optional1.setNameOptional("DOTA2");

        optionalDao.update(optional1);

        Optional optional2 = optionalDao.findById(1L);
        assertEquals("DOTA2", optional2.getNameOptional());

        Optional optional3 = optionalDao.findByName("DOTA2");

        assertEquals("DOTA2", optional3.getNameOptional());

        optionalDao.delete(optional3);
        assertEquals(0, optionalDao.findAll().size());


        ArchiveDao archiveDao = factory.getArchiveDao();
        Archive archive = new Archive();
        archive.setRating(10);

        archiveDao.save(archive);
        //archiveDao.save(archive);
        List<Archive> archives = archiveDao.findAll();
        assertEquals(1,archives.size());
        Archive archive1 = archiveDao.findById(1L);
        assertEquals(10, archive1.getRating());

        archive1.setRating(12);
        archiveDao.update(archive1);
    }
}

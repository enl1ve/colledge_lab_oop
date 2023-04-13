package org.example.config;

import org.example.dao.ArchiveDao;
import org.example.dao.OptionalDao;
import org.example.dao.StudentDao;
import org.example.repository.ArchiveRepository;
import org.example.repository.OptionalRepository;
import org.example.repository.StudentRepository;
import org.hibernate.SessionFactory;

import javax.persistence.Persistence;

public class Factory {
    public static Factory INSTANCE = new Factory();

    private final SessionFactory session;

    public Factory() {
        this.session = (SessionFactory) Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
    }

    public static Factory getInstance() {
        return INSTANCE;
    }

    public ArchiveDao getArchiveDao() {
        return new ArchiveRepository(session);
    }

    public OptionalDao getOptionalDao() {
        return new OptionalRepository(session);
    }

    public StudentDao getStudentDao() {
        return new StudentRepository(session);
    }

}

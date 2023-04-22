package org.example.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.model.DatabaseConnection;
import org.example.database.model.EchipaEntity;
import org.example.database.model.MeciEntity;

import java.util.List;

public class MeciDao implements DaoI<MeciEntity> {
    private DatabaseConnection connection = new DatabaseConnection();
    @Override
    public MeciEntity get(Long id) {
        return connection.getEntityManager().find(MeciEntity.class, Long.valueOf(id));
    }
    @Override
    public List<MeciEntity> getAll() {
        TypedQuery<MeciEntity> query = connection.getEntityManager().createQuery("SELECT a FROM MeciEntity a", MeciEntity.class);
        return query.getResultList();
    }
    @Override
    public void create(MeciEntity movie) {
        connection.executeTransaction(entityManager -> entityManager.persist(movie));
    }
}

package org.example.dao;

import jakarta.persistence.TypedQuery;
import org.example.database.model.DatabaseConnection;
import org.example.database.model.EchipaEntity;
import java.util.List;
public class EchipaDao implements DaoI<EchipaEntity> {
    private DatabaseConnection connection = new DatabaseConnection();
    @Override
    public EchipaEntity get(Long id) {
        return connection.getEntityManager().find(EchipaEntity.class, Long.valueOf(id));
    }
    public EchipaEntity getByNume(String numec) {
        EchipaEntity echipa = null;
        try {
            echipa = connection.getEntityManager().createQuery("SELECT u FROM EchipaEntity u WHERE u.nume=:numec", EchipaEntity.class)
                    .setParameter("numec", numec).getSingleResult();
        }catch(Exception ex){
            echipa = null;
        }finally {
            return echipa;
        }
    }
    @Override
    public List<EchipaEntity> getAll() {
        TypedQuery<EchipaEntity> query = connection.getEntityManager().createQuery("SELECT a FROM EchipaEntity a", EchipaEntity.class);
        return query.getResultList();
    }
    @Override
    public void create(EchipaEntity movie) {
        connection.executeTransaction(entityManager -> entityManager.persist(movie));
    }
    public List<EchipaEntity> getAllOrderedByPuncte() {
        TypedQuery<EchipaEntity> query = connection.getEntityManager().createQuery("SELECT a FROM EchipaEntity a ORDER BY a.puncte DESC", EchipaEntity.class);
        return query.getResultList();
    }
}

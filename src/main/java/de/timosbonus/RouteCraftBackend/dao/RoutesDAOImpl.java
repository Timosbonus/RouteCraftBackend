package de.timosbonus.RouteCraftBackend.dao;

import de.timosbonus.RouteCraftBackend.entity.Routes;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoutesDAOImpl implements RoutesDAO {

    private final EntityManager em;

    public RoutesDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Routes> findAll() {
        TypedQuery<Routes> query = em.createQuery("SELECT r FROM Routes r", Routes.class);
        return query.getResultList();
    }

    @Override
    public Routes findById(int id) {
        return em.find(Routes.class, id);
    }

    @Override
    public Routes save(Routes routes) {
        em.persist(routes);
        return routes;
    }

    @Override
    public Routes update(Routes routes) {
        return em.merge(routes);
    }

    @Override
    public void delete(Routes routes) {
        em.remove(em.contains(routes) ? routes : em.merge(routes));
    }
}

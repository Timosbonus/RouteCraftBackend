package de.timosbonus.RouteCraftBackend.dao;

import de.timosbonus.RouteCraftBackend.entity.Directions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DirectionsDAOImpl implements DirectionsDAO { // Implementiere das Interface

    // Define EntityManager
    private final EntityManager em;

    // Setup constructor injection
    public DirectionsDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Directions> findAllWithId(String id) {
        // Create query
        TypedQuery<Directions> query = em.createQuery("SELECT d FROM Directions d WHERE d.routeId = :routeId", Directions.class);
        query.setParameter("routeId", id); // setting param for query

        // get results List from query and return
        return query.getResultList();
    }

    @Override
    public Directions findById(int id) {
        // find direction based on generated Id
        return em.find(Directions.class, id);
    }

    @Override
    public Directions save(Directions directions) {
        em.persist(directions); // Save a new direction
        return directions;
    }

    @Override
    public Directions update(Directions directions) {
        return em.merge(directions); // updates an existing dir
    }

    @Override
    public void delete(Directions directions) {
        em.remove(em.contains(directions) ? directions : em.merge(directions)); // delete a direction
    }
}

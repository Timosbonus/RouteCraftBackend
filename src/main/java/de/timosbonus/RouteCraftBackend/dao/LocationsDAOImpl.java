package de.timosbonus.RouteCraftBackend.dao;

import de.timosbonus.RouteCraftBackend.entity.Locations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationsDAOImpl implements LocationsDAO {

    // define Entity Manager
    private final EntityManager em;

    // setup constructor injection
    public LocationsDAOImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Locations> findAllWithId(String id) {
        // create query
        TypedQuery<Locations> query = em.createQuery("SELECT d FROM Locations d WHERE d.routeId = :routeId", Locations.class);
        query.setParameter("routeId", id); // setting param for query

        // get result List from query and return
        return query.getResultList();
    }

    @Override
    public Locations findById(int id) {
        return em.find(Locations.class, id);
    }

    @Override
    public Locations save(Locations locations) {
        em.persist(locations);
        return locations;
    }

    @Override
    public Locations update(Locations locations) {
        return em.merge(locations);
    }

    @Override
    public void delete(Locations locations) {
        em.remove(em.contains(locations) ? locations : em.merge(locations));
    }
}

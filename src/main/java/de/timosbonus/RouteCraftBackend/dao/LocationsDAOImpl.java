package de.timosbonus.RouteCraftBackend.dao;

import de.timosbonus.RouteCraftBackend.entity.Locations;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        TypedQuery<Locations> query = em.createQuery("SELECT d FROM Locations d WHERE d.routeId = :routeId ORDER BY d.currentIndex ASC", Locations.class);
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

    // method accepts Array of Locations and saves, updates or deletes them in db
    @Override
    public List<Locations> updateSaveDeleteArray(String route_id, List<Locations> locations) {
        // gets all the existing Locations with the same route_id
        List<Locations> existingLocations = findAllWithId(route_id);

        // saves existingLocations in Set
        Set<Integer> encounteredIds = new HashSet<>();
        for (Locations locs : existingLocations) {
            encounteredIds.add(locs.getId());
        }

        // checks existingLocations if already existing and adds or updates
        for (Locations locs : locations) {
            int currentId = locs.getId();
            if (encounteredIds.contains(currentId)) {
                em.merge(locs);
            } else {
                em.persist(locs);
            }
            encounteredIds.remove(currentId); // deletes Id afterwards
        }

        // deletes the remaining Locations by Id
        for (int id : encounteredIds) {
            Locations locs = em.find(Locations.class, id);
            delete(locs);
        }



        return findAllWithId(route_id);
    }
}

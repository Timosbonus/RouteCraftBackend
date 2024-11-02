package de.timosbonus.RouteCraftBackend.dao;

import de.timosbonus.RouteCraftBackend.entity.Directions;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        TypedQuery<Directions> query = em.createQuery("SELECT d FROM Directions d WHERE d.routeId = :routeId  ORDER BY d.currentIndex ASC", Directions.class);

        query.setParameter("routeId", id); // setting param for query

        // get results List from query
        List<Directions> directionsList = query.getResultList();

        // give every direction the correct current Index
        for (int i = 0; i < directionsList.size(); i++) {
            directionsList.get(i).setCurrentIndex(i);
        }

        return directionsList;
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


    // method accepts Array of Directions and saves them in db
    @Override
    public List<Directions> updateSaveDeleteArray(String route_id, List<Directions> directions) {
        // gets all the existing Directions with the same route_id
        List<Directions> existingDirections = findAllWithId(route_id);

        // saves existingDirections in Set
        Set<Integer> encounteredIds = new HashSet<>();
        for (Directions dir : existingDirections) {
            encounteredIds.add(dir.getId());
        }

        // checks existingDirections if already existing and adds or updates
        for (Directions dir : directions) {
            int currentId = dir.getId();
            if (encounteredIds.contains(currentId)) {
                em.merge(dir);
            } else {
                em.persist(dir);
            }
            encounteredIds.remove(currentId); // deletes Id afterwards
        }

        // deletes the remaining Directions by Id
        for (int id : encounteredIds) {
            Directions dir = em.find(Directions.class, id);
            delete(dir);
        }

        return findAllWithId(route_id);
    }

    @Override
    public List<Directions> getAll() {
        return em.createQuery("SELECT d FROM Directions d", Directions.class).getResultList();
    }
}

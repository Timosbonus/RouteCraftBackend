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
        // Erstelle die Abfrage
        TypedQuery<Directions> query = em.createQuery("SELECT d FROM Directions d WHERE d.routeId = :routeId", Directions.class);
        query.setParameter("routeId", id); // Setze den Parameter für die route_id

        // Führe die Abfrage aus und hole die Ergebnisse
        List<Directions> directions = query.getResultList();
        return directions;
    }

    @Override
    public Directions findById(int id) {
        // Finde eine Direction basierend auf der ID
        return em.find(Directions.class, id);
    }

    @Override
    public Directions save(Directions directions) {
        em.persist(directions); // Speichern der neuen Direction
        return directions;
    }

    @Override
    public Directions update(Directions directions) {
        return em.merge(directions); // Aktualisieren der Direction
    }

    @Override
    public void delete(Directions directions) {
        em.remove(em.contains(directions) ? directions : em.merge(directions)); // Löschen der Direction
    }
}

package de.timosbonus.RouteCraftBackend.service;

import de.timosbonus.RouteCraftBackend.dao.DirectionsDAO;
import de.timosbonus.RouteCraftBackend.entity.Directions;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectionsServiceImpl implements DirectionsService {

    private DirectionsDAO directionsDAO;

    @Autowired
    public DirectionsServiceImpl(DirectionsDAO directionsDAO) {
        this.directionsDAO = directionsDAO;
    }

    @Override
    public List<Directions> getAll() {
        return directionsDAO.getAll();
    }

    @Override
    public List<Directions> findAllWithId(String id) {
        return directionsDAO.findAllWithId(id);
    }

    @Override
    public Directions findById(int id) {
        return directionsDAO.findById(id);
    }

    @Override
    @Transactional
    public Directions save(Directions directions) {
        return directionsDAO.save(directions);
    }

    @Override
    @Transactional
    public Directions update(Directions directions) {
        return directionsDAO.update(directions);
    }

    @Override
    @Transactional
    public void delete(Directions directions) {
        directionsDAO.delete(directions);
    }

    @Override
    @Transactional
    public List<Directions> updateSaveDeleteArray(String route_id, List<Directions> directions) {
        return directionsDAO.updateSaveDeleteArray(route_id, directions);
    }
}

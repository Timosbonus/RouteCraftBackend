package de.timosbonus.RouteCraftBackend.service;

import de.timosbonus.RouteCraftBackend.dao.LocationsDAO;
import de.timosbonus.RouteCraftBackend.entity.Locations;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsServiceImpl implements LocationsService {

    private LocationsDAO locationsDAO;

    @Autowired
    public LocationsServiceImpl(LocationsDAO locationsDAO) {
        this.locationsDAO = locationsDAO;
    }

    @Override
    public List<Locations> findAllWithId(String id) {
        return locationsDAO.findAllWithId(id);
    }

    @Override
    public Locations findById(int id) {
        return locationsDAO.findById(id);
    }

    @Override
    @Transactional
    public Locations save(Locations locations) {
        return locationsDAO.save(locations);
    }

    @Override
    @Transactional
    public Locations update(Locations locations) {
        return locationsDAO.update(locations);
    }

    @Override
    @Transactional
    public void delete(Locations locations) {
        locationsDAO.delete(locations);
    }

    @Override
    @Transactional
    public List<Locations> updateSaveDeleteArray(String route_id, List<Locations> locations) {
        return locationsDAO.updateSaveDeleteArray(route_id, locations);
    }
}

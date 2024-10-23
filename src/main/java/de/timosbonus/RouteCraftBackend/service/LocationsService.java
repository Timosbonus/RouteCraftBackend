package de.timosbonus.RouteCraftBackend.service;

import de.timosbonus.RouteCraftBackend.entity.Locations;

import java.util.List;

public interface LocationsService {
    List<Locations> findAllWithId(String id);
    Locations findById(int id);
    Locations save(Locations locations);
    Locations update(Locations locations);
    void delete(Locations locations);
    List<Locations> updateSaveDeleteArray(String route_id, List<Locations> locations);
}

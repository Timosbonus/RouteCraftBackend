package de.timosbonus.RouteCraftBackend.dao;

import de.timosbonus.RouteCraftBackend.entity.Locations;

import java.util.List;

public interface LocationsDAO {
    List<Locations> findAllWithId(String id);
    Locations findById(int id);
    Locations save(Locations locations);
    Locations update(Locations locations);
    void delete(Locations locations);
}

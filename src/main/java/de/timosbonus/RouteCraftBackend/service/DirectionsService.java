package de.timosbonus.RouteCraftBackend.service;

import de.timosbonus.RouteCraftBackend.entity.Directions;

import java.util.List;

public interface DirectionsService {
    List<Directions> findAllWithId(String id);
    Directions findById(int id);
    Directions save(Directions directions);
    Directions update(Directions directions);
    void delete(Directions directions);
    void updateSaveDeleteArray(String route_id, List<Directions> directions);
}

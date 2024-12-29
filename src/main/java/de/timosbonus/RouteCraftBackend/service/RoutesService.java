package de.timosbonus.RouteCraftBackend.service;

import de.timosbonus.RouteCraftBackend.entity.Routes;

import java.util.List;

public interface RoutesService {
    List<Routes> findAll();
    Routes findById(String id);
    Routes save(Routes routes);
    Routes update(Routes routes);
    void delete(Routes routes);
    boolean exists(String id);
}

package de.timosbonus.RouteCraftBackend.dao;

import de.timosbonus.RouteCraftBackend.entity.Routes;

import java.util.List;

public interface RoutesDAO {
    List<Routes> findAll();
    Routes findById(String routeId);
    Routes save(Routes routes);
    Routes update(Routes routes);
    void delete(Routes routes);
    boolean exists(String routeId);
}

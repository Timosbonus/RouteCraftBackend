package de.timosbonus.RouteCraftBackend.service;

import de.timosbonus.RouteCraftBackend.dao.RoutesDAO;
import de.timosbonus.RouteCraftBackend.entity.Routes;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoutesServiceImpl implements RoutesService {

    private RoutesDAO routesDAO;

    @Autowired
    public RoutesServiceImpl(RoutesDAO routesDAO) {
        this.routesDAO = routesDAO;
    }

    @Override
    public List<Routes> findAll() {
        return routesDAO.findAll();
    }

    @Override
    public Routes findById(int id) {
        return routesDAO.findById(id);
    }

    @Transactional
    @Override
    public Routes save(Routes routes) {
        return routesDAO.save(routes);
    }

    @Transactional
    @Override
    public Routes update(Routes routes) {
        return routesDAO.update(routes);
    }

    @Transactional
    @Override
    public void delete(Routes routes) {
        routesDAO.delete(routes);
    }
}

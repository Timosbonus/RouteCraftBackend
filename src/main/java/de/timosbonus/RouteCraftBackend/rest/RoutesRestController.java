package de.timosbonus.RouteCraftBackend.rest;

import de.timosbonus.RouteCraftBackend.entity.Routes;
import de.timosbonus.RouteCraftBackend.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoutesRestController {

    private final RoutesService routesService;

    @Autowired
    public RoutesRestController(RoutesService routesService) {
        this.routesService = routesService;
    }

    @GetMapping("/routes/all")
    public List<Routes> findAll() {
        return routesService.findAll();
    }

    @GetMapping("/routes/{id}")
    public Routes findById(@PathVariable int id) {
        return routesService.findById(id);
    }

    @PostMapping("/routes")
    public Routes save(@RequestBody Routes routes) {
        return routesService.save(routes);
    }

    @PutMapping("/routes")
    public Routes update(@RequestBody Routes routes) {
        return routesService.update(routes);
    }

    @DeleteMapping("/routes/{id}")
    public Routes delete(@PathVariable int id) {
        Routes routes = routesService.findById(id);
        routesService.delete(routes);
        return routes;
    }
}

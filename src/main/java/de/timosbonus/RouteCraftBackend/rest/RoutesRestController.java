package de.timosbonus.RouteCraftBackend.rest;

import de.timosbonus.RouteCraftBackend.entity.Routes;
import de.timosbonus.RouteCraftBackend.service.RoutesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Routes> routes = routesService.findAll();
        routes.sort(Comparator.comparing(Routes::getId). reversed());
        int maxLen = Math.min(routes.size(), 20);
        return routes.subList(0, maxLen);
    }

    @GetMapping("/routes/{routeId}")
    public Routes findById(@PathVariable String routeId) {
        return routesService.findById(routeId);
    }
/*
    @PostMapping("/routes")
    public Routes save(@RequestBody Routes routes) {
        return routesService.save(routes);
    }
*/

    @GetMapping("routes/check/{routeId}")
    public boolean check(@PathVariable String routeId) {
        return routesService.exists(routeId);
    }


    @PutMapping("/routes")
    public Routes update(@RequestBody Routes routes) {
        return routesService.update(routes);
    }

    @DeleteMapping("/routes/{routeId}")
    public Routes delete(@PathVariable String routeId) {
        Routes routes = routesService.findById(routeId);
        routesService.delete(routes);
        return routes;
    }
}

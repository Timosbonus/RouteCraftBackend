package de.timosbonus.RouteCraftBackend.rest;

import de.timosbonus.RouteCraftBackend.entity.Directions;
import de.timosbonus.RouteCraftBackend.service.DirectionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DirectionsRestController {

    private final DirectionsService directionsService;

    @Autowired
    public DirectionsRestController(DirectionsService directionsService) {
        this.directionsService = directionsService;
    }

    @GetMapping("/directions/{route_id}")
    public List<Directions> findAllWithId(@PathVariable("route_id") String routeId) {
        return directionsService.findAllWithId(routeId);
    }

    @GetMapping("/directions/{direction_id}")
    public Directions findById(@PathVariable("direction_id") int id) {
        return directionsService.findById(id);
    }

    @PostMapping("/directions")
    public Directions save(@RequestBody Directions directions) {
        return directionsService.save(directions);
    }

    @PutMapping("/directions")
    public Directions update(@RequestBody Directions directions) {
        return directionsService.update(directions);
    }

    @DeleteMapping("/directions/{direction_id}")
    public void delete(@PathVariable("direction_id") int id) {
        Directions directions = directionsService.findById(id);
        directionsService.delete(directions);
    }
}


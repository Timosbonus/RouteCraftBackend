package de.timosbonus.RouteCraftBackend.rest;

import de.timosbonus.RouteCraftBackend.entity.Locations;
import de.timosbonus.RouteCraftBackend.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LocationsRestController {

    private final LocationsService locationsService;

    @Autowired
    public LocationsRestController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @GetMapping("/locations/spec/{route_id}")
    public List<Locations> findAllWithId(@PathVariable("route_id") String route_id) {
        return locationsService.findAllWithId(route_id);
    }

    @GetMapping("/locations/{location_id}")
    public Locations findById(@PathVariable("location_id") int location_id) {
        return locationsService.findById(location_id);
    }

    @PostMapping("/locations")
    public Locations save(@RequestBody Locations locations) {
        return locationsService.save(locations);
    }

    @PutMapping("/locations")
    public Locations update(@RequestBody Locations locations) {
        return locationsService.update(locations);
    }

    @DeleteMapping("/locations/{location_id}")
    public void delete(@PathVariable("location_id") int location_id) {
        Locations locations = locationsService.findById(location_id);
        locationsService.delete(locations);
    }

    @PutMapping("/locations/{route_id}")
    public List<Locations> updateSaveDeleteArray(@PathVariable String route_id, @RequestBody List<Locations> locations) {
        return locationsService.updateSaveDeleteArray(route_id, locations);
    }

}

package de.timosbonus.RouteCraftBackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "directions")
public class Directions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "route_id")
    private String routeId;

    @Column(name = "routes")
    private String routes;

    @Column(name = "waypoints")
    private String waypoints;


    public Directions() {}

    public Directions(String routeId, String routes, String waypoints) {
        this.routeId = routeId;
        this.routes = routes;
        this.waypoints = waypoints;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    public String getRoutes() {
        return routes;
    }

    public void setRoutes(String routes) {
        this.routes = routes;
    }

    public String getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(String waypoints) {
        this.waypoints = waypoints;
    }

    @Override
    public String toString() {
        return "Directions{" +
                "id=" + id +
                ", routeId='" + routeId + '\'' +
                ", routes='" + routes + '\'' +
                ", waypoints='" + waypoints + '\'' +
                '}';
    }
}

package de.timosbonus.RouteCraftBackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "locations")
public class Locations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "route_id")
    private String routeId;

    @Column(name = "break_duration")
    private int breakDuration;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;

    public Locations() {}

    public Locations(String routeId, int breakDuration, String displayName, String lat, String lon) {
        this.routeId = routeId;
        this.breakDuration = breakDuration;
        this.displayName = displayName;
        this.lat = lat;
        this.lon = lon;
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

    public int getBreakDuration() {
        return breakDuration;
    }

    public void setBreakDuration(int breakDuration) {
        this.breakDuration = breakDuration;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }
}
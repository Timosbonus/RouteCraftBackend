package de.timosbonus.RouteCraftBackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("display_name") // annotation for different Json name then String name
    private String displayName;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;

    @Column(name = "place_id")
    @JsonProperty("place_id")
    private String placeId;

    @Column(name = "current_index")
    @JsonProperty("current_index")
    private int currentIndex;


    public Locations() {}

    public Locations(String routeId, int breakDuration, String displayName, String lat, String lon, String placeId, int currentIndex) {
        this.routeId = routeId;
        this.breakDuration = breakDuration;
        this.displayName = displayName;
        this.lat = lat;
        this.lon = lon;
        this.placeId = placeId;
        this.currentIndex = currentIndex;
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


    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
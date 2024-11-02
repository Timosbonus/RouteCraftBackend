package de.timosbonus.RouteCraftBackend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "directions")
public class Directions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "route_id")
    @JsonProperty("route_id")
    private String routeId;

    @Column(name = "geometry")
    private String geometry;

    @Column(name = "location_connection")
    @JsonProperty("location_connection")
    private String locationConnection;


    @Column(name = "current_index")
    @JsonProperty("current_index")
    private int currentIndex;



    public Directions() {}

    public Directions(int id, String routeId, String geometry, String locationConnection, int currentIndex) {
        this.id = id;
        this.routeId = routeId;
        this.geometry = geometry;
        this.locationConnection = locationConnection;
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

    public String getGeometry() {
        return geometry;
    }

    public void setGeometry(String geometry) {
        this.geometry = geometry;
    }

    public String getLocationConnection() {
        return locationConnection;
    }

    public void setLocationConnection(String locationConnection) {
        this.locationConnection = locationConnection;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
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


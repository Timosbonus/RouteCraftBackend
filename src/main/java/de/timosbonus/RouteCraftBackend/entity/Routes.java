package de.timosbonus.RouteCraftBackend.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "default_break_duration")
    private int defaultBreakDuration;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "route_id")
    private String routeId;

    public Routes() {}

    public Routes(int defaultBreakDuration, LocalTime startTime, String routeId) {
        this.defaultBreakDuration = defaultBreakDuration;
        this.startTime = startTime;
        this.routeId = routeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefaultBreakDuration() {
        return defaultBreakDuration;
    }

    public void setDefaultBreakDuration(int defaultBreakDuration) {
        this.defaultBreakDuration = defaultBreakDuration;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "id=" + id +
                ", defaultBreakDuration=" + defaultBreakDuration +
                ", startTime=" + startTime +
                ", routeId='" + routeId + '\'' +
                '}';
    }
}

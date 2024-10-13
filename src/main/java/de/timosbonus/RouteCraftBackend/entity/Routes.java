package de.timosbonus.RouteCraftBackend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "routes")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "default_break_duration")
    private int defaultBreakDuration;

    @Column(name = "start_time")
    private LocalDate startTime;

    @Column(name = "route_id")
    private String routeId;

    public Routes() {}

    public Routes(String name, int defaultBreakDuration, LocalDate startTime) {
        this.name = name;
        this.defaultBreakDuration = defaultBreakDuration;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefaultBreakDuration() {
        return defaultBreakDuration;
    }

    public void setDefaultBreakDuration(int defaultBreakDuration) {
        this.defaultBreakDuration = defaultBreakDuration;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
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
                ", name='" + name + '\'' +
                ", defaultBreakDuration=" + defaultBreakDuration +
                ", startTime=" + startTime +
                ", routeId='" + routeId + '\'' +
                '}';
    }
}

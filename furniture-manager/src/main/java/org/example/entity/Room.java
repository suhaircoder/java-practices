package org.example.entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double area;
    private int floor;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Sofa> sofas = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Bed> beds = new ArrayList<>();

    // Constructor
    public Room() {}

    public Room(String name, double area, int floor) {
        this.name = name;
        this.area = area;
        this.floor = floor;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public List<Sofa> getSofas() {
        return sofas;
    }

    public List<Bed> getBeds() {
        return beds;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setSofas(List<Sofa> sofas) {
        this.sofas = sofas;
    }

    public void setBeds(List<Bed> beds) {
        this.beds = beds;
    }
}

package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "beds")
public class Bed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private double price;
    private String size;
    private boolean hasStorage;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    // Default constructor
    public Bed() {
    }

    // Constructor with parameters
    public Bed(String model, double price, String size, boolean hasStorage) {
        this.model = model;
        this.price = price;
        this.size = size;
        this.hasStorage = hasStorage;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public String getSize() {
        return size;
    }

    public boolean isHasStorage() {
        return hasStorage;
    }

    public Room getRoom() {
        return room;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setHasStorage(boolean hasStorage) {
        this.hasStorage = hasStorage;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

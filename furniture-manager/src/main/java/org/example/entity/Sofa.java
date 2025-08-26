package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "sofas")
public class Sofa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String material;
    private Integer seatingCapacity;
    private Double price;        // Added price field
    private String model;        // Added model field
    private Boolean convertible; // Added convertible field

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    // Default constructor
    public Sofa() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Boolean getConvertible() {
        return convertible;
    }

    public void setConvertible(Boolean convertible) {
        this.convertible = convertible;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Sofa{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", material='" + material + '\'' +
                ", seatingCapacity=" + seatingCapacity +
                ", price=" + price +
                ", convertible=" + convertible +
                '}';
    }
}
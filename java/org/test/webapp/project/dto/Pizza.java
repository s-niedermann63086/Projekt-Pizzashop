package org.test.webapp.project.dto;

public class Pizza {

    private Long id;
    private String name;
    private Double price;

    public Pizza(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return "#" + id + " Pizza: " + name + " Preis: " + price;
    }


}

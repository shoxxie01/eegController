package com.shoxxie.eegcontroller.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ModelEeg {

    @Id
    private Integer id;
    private String username;
    private Integer electrodeNumber;
    private String image;

    public ModelEeg(Integer id, String username, Integer electrodeNumber, String image) {
        this.id = id;
        this.username = username;
        this.electrodeNumber = electrodeNumber;
        this.image = image;
    }

    public ModelEeg() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getElectrodeNumber() {
        return electrodeNumber;
    }

    public void setElectrodeNumber(Integer electrodeNumber) {
        this.electrodeNumber = electrodeNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ModelEeg{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", electrodeNumber=" + electrodeNumber +
                ", image='" + image + '\'' +
                '}';
    }
}

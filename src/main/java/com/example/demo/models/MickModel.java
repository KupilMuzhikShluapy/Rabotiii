package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MickModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title, type, model, soundsLike, country;
    private int hzstart, hzend, price;

    public MickModel() {
    }

    public MickModel(String title, String type, String model, String soundsLike, String country, int hzstart, int hzend, int price) {
        this.title = title;
        this.type = type;
        this.model = model;
        this.soundsLike = soundsLike;
        this.country = country;
        this.hzstart = hzstart;
        this.hzend = hzend;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSoundsLike() {
        return soundsLike;
    }

    public void setSoundsLike(String soundsLike) {
        this.soundsLike = soundsLike;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getHzstart() {
        return hzstart;
    }

    public void setHzstart(int hzstart) {
        this.hzstart = hzstart;
    }

    public int getHzend() {
        return hzend;
    }

    public void setHzend(int hzend) {
        this.hzend = hzend;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

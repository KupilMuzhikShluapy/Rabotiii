package com.example.demo.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class HeadphoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Переменная не может быть пустой")
    @Size(min = 2, max = 100, message = "Поле должно быть от 2 до 100 символов")
    private String title, type, model;

    @NotEmpty(message = "Переменная не может быть пустой")
    @Size(min = 2, max = 10, message = "Поле должно быть от 2 до 10 символов")
    private int hzstart, hzend, price;

    public HeadphoneModel() {
    }

    public HeadphoneModel(String title, String type, String model, int hzstart, int hzend, int price) {
        this.title = title;
        this.type = type;
        this.model = model;
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

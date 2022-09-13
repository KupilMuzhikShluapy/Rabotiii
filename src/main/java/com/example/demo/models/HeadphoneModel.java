package com.example.demo.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class HeadphoneModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 2, max = 100, message = "Поле должно быть от 2 до 100 символов")
    private String title, type, model;

    @NotNull(message = "Значение не может быть пустым")
    private int hzstart, hzend, price;

    private Long action;

    public HeadphoneModel() {
    }

    public HeadphoneModel(String title, String type, String model, int hzstart, int hzend, int price, Long action) {
        this.title = title;
        this.type = type;
        this.model = model;
        this.hzstart = hzstart;
        this.hzend = hzend;
        this.price = price;
        this.action = action;
    }

    public Long getAction() {
        return action;
    }

    public void setAction(Long action) {
        this.action = action;
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

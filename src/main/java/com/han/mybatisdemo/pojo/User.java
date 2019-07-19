package com.han.mybatisdemo.pojo;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String name;
    private int id;
    private double money;

    private List<Oder> oders;

    public User() {
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Oder> getOders() {
        return oders;
    }

    public void setOders(List<Oder> oders) {
        this.oders = oders;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", oders=" + oders +
                '}';
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

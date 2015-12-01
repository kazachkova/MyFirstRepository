package com.kazachkova.web.gwt.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Enrollee implements IsSerializable {
    private String login;
    private String name;
    private String surname;
    private int sub_1;
    private int sub_2;
    private int sub_3;
    private String depName;
    private double average;
    private int sumScore;
    private String status;
    private String result;
     public Enrollee(String name, String surname, String depName, int sumScore, double average, String status, String result) {
         this.name = name;
         this.surname = surname;
         this.depName = depName;
         this.sumScore = sumScore;
         this.average = average;
         this.status = status;
         this.result = result;
     }
    public Enrollee(String login, double average, int sumScore, String status, String result){
        this.login = login;
        this.sumScore = sumScore;
        this.average = average;
        this.status = status;
        this.result = result;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Enrollee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public int getSumScore() {
        return sumScore;
    }

    public void setSumScore(int sumScore) {
        this.sumScore = sumScore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

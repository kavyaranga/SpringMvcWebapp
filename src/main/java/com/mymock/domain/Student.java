package com.mymock.domain;

import javax.persistence.*;

/**
 * Created by rkavya on 3/19/2015.
 */
@Entity
public class Student {

    @Id
    private int id;

    private String name;

    private String pword;

    public Student() {
    }

    public Student(int id, String name, String pword) {
        this.id = id;
        this.name = name;
        this.pword = pword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPword() {
        return pword;
    }

    public void setPword(String pword) {
        this.pword = pword;
    }
}


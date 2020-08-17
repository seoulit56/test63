package com.seoulit.app.system.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Member
 */
@Entity
@Table(name = Member.TABLE_NAME)
public class Member {

    public static final String TABLE_NAME = "MEMBER";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DES")    
    private String des;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    

}
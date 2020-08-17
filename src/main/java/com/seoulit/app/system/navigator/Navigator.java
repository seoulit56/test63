package com.seoulit.app.system.navigator;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * Navigator
 */
@Entity
@Table(name = Navigator.TABLE_NAME)
public class Navigator {

    public static final String TABLE_NAME = "NAVIGATOR";


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME + "_SEQ")
    @SequenceGenerator(name = TABLE_NAME + "_SEQ", sequenceName = TABLE_NAME + "_SEQ", allocationSize = 1) 
    @NotNull 
    @Column(name = "ID")
    private int id;

    @Column(name = "PARENT")
    private String parent;

    @NotNull 
    @Column(name = "NAVIGATOR_ID")
    private String navigatorId;

    @NotNull 
    @Column(name = "NAVIGATOR_NAME")
    private String navigatorName;

    @NotNull 
    @Column(name = "URL")
    private String url;

    @NotNull 
    @Column(name = "DESKTOP")
    private String desktop;

    @NotNull 
    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "DESCRIPTION")
    private String description;

    @NotNull 
    @Column(name = "NAVIGATOR_SEQ")
    private int navigatorSeq;

    @NotNull 
    @Column(name = "CREATE_ID")
    private String createId;

    @CreationTimestamp
    @Column(name = "CREATE_DT")
    private Date createDt;

    @NotNull 
    @Column(name = "UPDATE_ID")
    private String updateId;
    
    @UpdateTimestamp
    @Column(name = "UPDATE_DT")
    private Date updateDt;

    @Column(name = "CLASS_TYPE")
    private String classType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getNavigatorId() {
        return navigatorId;
    }

    public void setNavigatorId(String navigatorId) {
        this.navigatorId = navigatorId;
    }

    public String getNavigatorName() {
        return navigatorName;
    }

    public void setNavigatorName(String navigatorName) {
        this.navigatorName = navigatorName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesktop() {
        return desktop;
    }

    public void setDesktop(String desktop) {
        this.desktop = desktop;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNavigatorSeq() {
        return navigatorSeq;
    }

    public void setNavigatorSeq(int navigatorSeq) {
        this.navigatorSeq = navigatorSeq;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Date updateDt) {
        this.updateDt = updateDt;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }




}
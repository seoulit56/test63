package com.seoulit.app.system.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * DomainDetail
 */
@Entity
@Table(name = DomainDetail.TABLE_NAME)
public class DomainDetail {

    public static final String TABLE_NAME = "SIDOMAIN_DETAIL";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME + "_SEQ")
    @SequenceGenerator(name = TABLE_NAME + "_SEQ", sequenceName = TABLE_NAME + "_SEQ", allocationSize = 1) 
    @NotNull
    @Column(name = "ID")
    private int id;

    @NotNull 
    @Column(name = "DOMAIN_ID", length = 20)
    private String domainId;

    @NotNull 
    @Column(name = "KEY", length = 20)
    private String key;

    @NotNull 
    @Column(name = "VALUE", length = 20)
    private String value;

    @Column(name = "NO")
    private int no;

    @NotNull 
    @Column(name = "KEY_USING")
    private Boolean keyUsing;

    @Column(name = "DESCRIPTION", length = 30)
    private String description;

    @NotNull 
    @Column(name = "CREATE_ID", length = 20)
    private String createId;

    @CreationTimestamp
    @Column(name = "CREATE_DT")
    private Timestamp createDt;

    @NotNull 
    @Column(name = "UPDATE_ID", length = 20)
    private String updateId;

    @UpdateTimestamp
    @Column(name = "UPDATE_DT")
    private Timestamp updateDt;

    @Transient
    @Column(name = "STATUS")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Timestamp getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Timestamp createDt) {
        this.createDt = createDt;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Timestamp getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(Timestamp updateDt) {
        this.updateDt = updateDt;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }


    public Boolean isKeyUsing() {
        return keyUsing;
    }

    public void setKeyUsing(Boolean keyUsing) {
        this.keyUsing = keyUsing;
    }

}
package com.seoulit.app.system.domain;

import java.sql.Timestamp;
import java.util.List;

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
 * Domain
 */
@Entity
@Table(name = Domain.TABLE_NAME)
public class Domain {

    public static final String TABLE_NAME = "SIDOMAIN";

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
    @Column(name = "DOMAIN_NAME", length = 20)
    private String domainName;

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
    @Column(name = "DOMAIN_DETAIL")
    private List<DomainDetail> domainDetail;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(final String domainId) {
        this.domainId = domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(final String domainName) {
        this.domainName = domainName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(final String createId) {
        this.createId = createId;
    }

    public Timestamp getCreateDt() {
        return createDt;
    }

    public void setCreateDt(final Timestamp createDt) {
        this.createDt = createDt;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(final String updateId) {
        this.updateId = updateId;
    }

    public Timestamp getUpdateDt() {
        return updateDt;
    }

    public void setUpdateDt(final Timestamp updateDt) {
        this.updateDt = updateDt;
    }

    public List<DomainDetail> getDomainDetail() {
        return domainDetail;
    }

    public void setDomainDetail(List<DomainDetail> domainDetail) {
        this.domainDetail = domainDetail;
    }
}
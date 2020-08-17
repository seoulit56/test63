package com.seoulit.app.system.label;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;

/**
 * Label
 */
@Entity
@Table(name = Label.TABLE_NAME)
public class Label {

    public static final String TABLE_NAME = "SILABEL";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME + "_SEQ")
    @SequenceGenerator(name = TABLE_NAME + "_SEQ", sequenceName = TABLE_NAME + "_SEQ", allocationSize = 1) 
    @NotNull
    @Column(name = "ID")
    private int id;

    @NotNull 
    @Column(name = "APPLICATION", length = 15)
    private String application;

    @NotNull 
    @Column(name = "LABEL", length = 12)
    private String label;

    @Column(name = "DESCRIPTION", length = 50)
    private String description;

    @Column(name = "LANG", length = 5)
    private String lang;

    @UpdateTimestamp
    @Column(name = "UPDATE_DT")
    private Timestamp updateDt;



    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the application
     */
    public String getApplication() {
        return application;
    }

    /**
     * @param application the application to set
     */
    public void setApplication(String application) {
        this.application = application;
    }

    /**
     * @return String return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the lang
     */
    public String getLang() {
        return lang;
    }

    /**
     * @param lang the lang to set
     */
    public void setLang(String lang) {
        this.lang = lang;
    }

    /**
     * @return Timestamp return the updateDt
     */
    public Timestamp getUpdateDt() {
        return updateDt;
    }

    /**
     * @param updateDt the updateDt to set
     */
    public void setUpdateDt(Timestamp updateDt) {
        this.updateDt = updateDt;
    }

}
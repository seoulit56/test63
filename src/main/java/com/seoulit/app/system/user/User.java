package com.seoulit.app.system.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

/**
 * User
 */
@Entity
@Table(name = User.TABLE_NAME)
@DynamicInsert
public class User {

    public static final String TABLE_NAME = "SIUSER";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TABLE_NAME + "_SEQ")
    @SequenceGenerator(name = TABLE_NAME + "_SEQ", sequenceName = TABLE_NAME + "_SEQ", allocationSize = 1) 
    @NotNull
    @Column(name = "ID")
    private int id;

    @NotNull 
    @Column(name = "USER_ID", length = 20)
    private String userId;

    @NotNull 
    @Column(name = "USER_NAME", length = 20)
    private String userName;

    @NotNull 
    @Column(name = "PASSWORD", length = 50)
    private String password;

    @NotNull 
    @Column(name = "TEL", length = 13)
    private String tel;

    @NotNull 
    @Column(name = "EMAIL", length = 30)
    private String email;

    @Column(name = "ADDRESS", length = 50)
    private String address;

    @NotNull 
    @Column(name = "BIRTHDAY")
    private Timestamp birthday;

    @NotNull 
    @Column(name = "GENDER", length = 1)
    private String gender;
 
    @Column(name = "STATUS", length = 10)
    private String status;
 
    @Column(name = "CONFIRM")
    private Boolean confirm;

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

    @NotNull 
    @Column(name = "USERTYPE", length = 20)
    private String usertype;

    @Column(name = "COMMENT", length = 50)
    private String comment;    


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
     * @return String return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return String return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return Timestamp return the birthday
     */
    public Timestamp getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    /**
     * @return String return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return String return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return Boolean return the confirm
     */
    public Boolean isConfirm() {
        return confirm;
    }

    /**
     * @param confirm the confirm to set
     */
    public void setConfirm(Boolean confirm) {
        this.confirm = confirm;
    }

    /**
     * @return String return the createId
     */
    public String getCreateId() {
        return createId;
    }

    /**
     * @param createId the createId to set
     */
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    /**
     * @return Timestamp return the createDt
     */
    public Timestamp getCreateDt() {
        return createDt;
    }

    /**
     * @param createDt the createDt to set
     */
    public void setCreateDt(Timestamp createDt) {
        this.createDt = createDt;
    }

    /**
     * @return String return the updateId
     */
    public String getUpdateId() {
        return updateId;
    }

    /**
     * @param updateId the updateId to set
     */
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
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

    /**
     * @return String return the usertype
     */
    public String getUsertype() {
        return usertype;
    }

    /**
     * @param usertype the usertype to set
     */
    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * @return String return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

}
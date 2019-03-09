package com.carsystem.entity;

import java.util.Date;
import javax.persistence.*;

public class Cuser {
    @Id
    @Column(name = "c_id")
    private Integer cId;

    @Column(name = "c_name")
    private String cName;

    @Column(name = "c_password")
    private String cPassword;

    @Column(name = "c_telnumber")
    private String cTelnumber;

    @Column(name = "c_birthdate")
    private Date cBirthdate;

    @Column(name = "c_idnumber")
    private String cIdnumber;

    @Column(name = "c_idtype")
    private String cIdtype;

    @Column(name = "c_cartype")
    private String cCartype;

    @Column(name = "c_email")
    private String cEmail;

    @Column(name = "c_address")
    private String cAddress;

    /**
     * @return c_id
     */
    public Integer getcId() {
        return cId;
    }

    /**
     * @param cId
     */
    public void setcId(Integer cId) {
        this.cId = cId;
    }

    /**
     * @return c_name
     */
    public String getcName() {
        return cName;
    }

    /**
     * @param cName
     */
    public void setcName(String cName) {
        this.cName = cName;
    }

    /**
     * @return c_password
     */
    public String getcPassword() {
        return cPassword;
    }

    /**
     * @param cPassword
     */
    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    /**
     * @return c_telnumber
     */
    public String getcTelnumber() {
        return cTelnumber;
    }

    /**
     * @param cTelnumber
     */
    public void setcTelnumber(String cTelnumber) {
        this.cTelnumber = cTelnumber;
    }

    /**
     * @return c_birthdate
     */
    public Date getcBirthdate() {
        return cBirthdate;
    }

    /**
     * @param cBirthdate
     */
    public void setcBirthdate(Date cBirthdate) {
        this.cBirthdate = cBirthdate;
    }

    /**
     * @return c_idnumber
     */
    public String getcIdnumber() {
        return cIdnumber;
    }

    /**
     * @param cIdnumber
     */
    public void setcIdnumber(String cIdnumber) {
        this.cIdnumber = cIdnumber;
    }

    /**
     * @return c_idtype
     */
    public String getcIdtype() {
        return cIdtype;
    }

    /**
     * @param cIdtype
     */
    public void setcIdtype(String cIdtype) {
        this.cIdtype = cIdtype;
    }

    /**
     * @return c_cartype
     */
    public String getcCartype() {
        return cCartype;
    }

    /**
     * @param cCartype
     */
    public void setcCartype(String cCartype) {
        this.cCartype = cCartype;
    }

    /**
     * @return c_email
     */
    public String getcEmail() {
        return cEmail;
    }

    /**
     * @param cEmail
     */
    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    /**
     * @return c_address
     */
    public String getcAddress() {
        return cAddress;
    }

    /**
     * @param cAddress
     */
    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }
}
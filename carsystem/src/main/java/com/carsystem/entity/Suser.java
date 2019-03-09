package com.carsystem.entity;

import javax.persistence.*;

public class Suser {
    @Id
    @Column(name = "s_id")
    private Integer sId;

    @Column(name = "s_name")
    private String sName;

    @Column(name = "s_password")
    private String sPassword;

    @Column(name = "s_telnumber")
    private String sTelnumber;

    /**
     * @return s_id
     */
    public Integer getsId() {
        return sId;
    }

    /**
     * @param sId
     */
    public void setsId(Integer sId) {
        this.sId = sId;
    }

    /**
     * @return s_name
     */
    public String getsName() {
        return sName;
    }

    /**
     * @param sName
     */
    public void setsName(String sName) {
        this.sName = sName;
    }

    /**
     * @return s_password
     */
    public String getsPassword() {
        return sPassword;
    }

    /**
     * @param sPassword
     */
    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    /**
     * @return s_telnumber
     */
    public String getsTelnumber() {
        return sTelnumber;
    }

    /**
     * @param sTelnumber
     */
    public void setsTelnumber(String sTelnumber) {
        this.sTelnumber = sTelnumber;
    }
}
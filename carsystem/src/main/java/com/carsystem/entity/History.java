package com.carsystem.entity;

import javax.persistence.*;

public class History {
    @Id
    @Column(name = "h_id")
    private Integer hId;

    @Column(name = "h_number")
    private String hNumber;

    @Column(name = "a_applynumber")
    private String aApplynumber;

    @Column(name = "h_fk")
    private String hFk;

    /**
     * @return h_id
     */
    public Integer gethId() {
        return hId;
    }

    /**
     * @param hId
     */
    public void sethId(Integer hId) {
        this.hId = hId;
    }

    /**
     * @return h_number
     */
    public String gethNumber() {
        return hNumber;
    }

    /**
     * @param hNumber
     */
    public void sethNumber(String hNumber) {
        this.hNumber = hNumber;
    }

    /**
     * @return a_applynumber
     */
    public String getaApplynumber() {
        return aApplynumber;
    }

    /**
     * @param aApplynumber
     */
    public void setaApplynumber(String aApplynumber) {
        this.aApplynumber = aApplynumber;
    }

    /**
     * @return h_fk
     */
    public String gethFk() {
        return hFk;
    }

    /**
     * @param hFk
     */
    public void sethFk(String hFk) {
        this.hFk = hFk;
    }
}
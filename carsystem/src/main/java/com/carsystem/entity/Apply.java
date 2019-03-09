package com.carsystem.entity;

import javax.persistence.*;

public class Apply {
    @Id
    @Column(name = "a_id")
    private Integer aId;

    @Column(name = "a_applynumber")
    private String aApplynumber;

    @Column(name = "c_state")
    private String cState;

    @Column(name = "s_state")
    private String sState;

    @Column(name = "c_result")
    private String cResult;

    @Column(name = "a_fk")
    private String aFk;

    /**
     * @return a_id
     */
    public Integer getaId() {
        return aId;
    }

    /**
     * @param aId
     */
    public void setaId(Integer aId) {
        this.aId = aId;
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
     * @return c_state
     */
    public String getcState() {
        return cState;
    }

    /**
     * @param cState
     */
    public void setcState(String cState) {
        this.cState = cState;
    }

    /**
     * @return s_state
     */
    public String getsState() {
        return sState;
    }

    /**
     * @param sState
     */
    public void setsState(String sState) {
        this.sState = sState;
    }

    /**
     * @return c_result
     */
    public String getcResult() {
        return cResult;
    }

    /**
     * @param cResult
     */
    public void setcResult(String cResult) {
        this.cResult = cResult;
    }

    /**
     * @return a_fk
     */
    public String getaFk() {
        return aFk;
    }

    /**
     * @param aFk
     */
    public void setaFk(String aFk) {
        this.aFk = aFk;
    }
}
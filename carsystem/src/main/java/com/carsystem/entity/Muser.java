package com.carsystem.entity;

import javax.persistence.*;

public class Muser {
    @Id
    @Column(name = "m_id")
    private Integer mId;

    @Column(name = "m_name")
    private String mName;

    @Column(name = "m_password")
    private String mPassword;

    @Column(name = "m_telnumber")
    private String mTelnumber;

    /**
     * @return m_id
     */
    public Integer getmId() {
        return mId;
    }

    /**
     * @param mId
     */
    public void setmId(Integer mId) {
        this.mId = mId;
    }

    /**
     * @return m_name
     */
    public String getmName() {
        return mName;
    }

    /**
     * @param mName
     */
    public void setmName(String mName) {
        this.mName = mName;
    }

    /**
     * @return m_password
     */
    public String getmPassword() {
        return mPassword;
    }

    /**
     * @param mPassword
     */
    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    /**
     * @return m_telnumber
     */
    public String getmTelnumber() {
        return mTelnumber;
    }

    /**
     * @param mTelnumber
     */
    public void setmTelnumber(String mTelnumber) {
        this.mTelnumber = mTelnumber;
    }
}
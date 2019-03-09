package com.carsystem.entity;

import javax.persistence.*;

public class Policy {
    @Id
    @Column(name = "p_id")
    private Integer pId;

    @Column(name = "p_question")
    private String pQuestion;

    /**
     * @return p_id
     */
    public Integer getpId() {
        return pId;
    }

    /**
     * @param pId
     */
    public void setpId(Integer pId) {
        this.pId = pId;
    }

    /**
     * @return p_question
     */
    public String getpQuestion() {
        return pQuestion;
    }

    /**
     * @param pQuestion
     */
    public void setpQuestion(String pQuestion) {
        this.pQuestion = pQuestion;
    }
}
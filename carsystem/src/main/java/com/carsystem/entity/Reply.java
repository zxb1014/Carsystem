package com.carsystem.entity;

import javax.persistence.*;

public class Reply {
    @Id
    @Column(name = "reply_id")
    private Integer replyId;

    @Column(name = "reply_fk")
    private String replyFk;

    @Column(name = "reply_text")
    private String replyText;

    /**
     * @return reply_id
     */
    public Integer getReplyId() {
        return replyId;
    }

    /**
     * @param replyId
     */
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    /**
     * @return reply_fk
     */
    public String getReplyFk() {
        return replyFk;
    }

    /**
     * @param replyFk
     */
    public void setReplyFk(String replyFk) {
        this.replyFk = replyFk;
    }

    /**
     * @return reply_text
     */
    public String getReplyText() {
        return replyText;
    }

    /**
     * @param replyText
     */
    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }
}
package com.carsystem.entity;

import javax.persistence.*;

public class Notice {
    @Id
    @Column(name = "notice_id")
    private Integer noticeId;

    @Column(name = "notice_text")
    private String noticeText;

    @Column(name = "notice_headline")
    private String noticeHeadline;

    /**
     * @return notice_id
     */
    public Integer getNoticeId() {
        return noticeId;
    }

    /**
     * @param noticeId
     */
    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * @return notice_text
     */
    public String getNoticeText() {
        return noticeText;
    }

    /**
     * @param noticeText
     */
    public void setNoticeText(String noticeText) {
        this.noticeText = noticeText;
    }

    /**
     * @return notice_headline
     */
    public String getNoticeHeadline() {
        return noticeHeadline;
    }

    /**
     * @param noticeHeadline
     */
    public void setNoticeHeadline(String noticeHeadline) {
        this.noticeHeadline = noticeHeadline;
    }
}
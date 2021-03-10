package com.sci.da.front.Notice.dto;

public class NoticeMsgDTO {

    private String id;

    private String account;

    private String noticeId;

    private NoticeCenterDTO noticeCenterDTO;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public NoticeCenterDTO getNoticeCenterDTO() {
        return noticeCenterDTO;
    }

    public void setNoticeCenterDTO(NoticeCenterDTO noticeCenterDTO) {
        this.noticeCenterDTO = noticeCenterDTO;
    }

    public NoticeMsgDTO() {
        super();
    }

    public NoticeMsgDTO(String id, String account, String noticeId, NoticeCenterDTO noticeCenterDTO) {
        this.id = id;
        this.account = account;
        this.noticeId = noticeId;
        this.noticeCenterDTO = noticeCenterDTO;
    }
}

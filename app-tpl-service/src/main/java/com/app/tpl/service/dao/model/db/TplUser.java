package com.app.tpl.service.dao.model.db;

import java.util.Date;

public class TplUser {
    private Long userId;

    private Long recommentUserId;

    private Integer sex;

    private String mobile;

    private String password;

    private String imei;

    private Date createTime;

    private Date updateTim;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRecommentUserId() {
        return recommentUserId;
    }

    public void setRecommentUserId(Long recommentUserId) {
        this.recommentUserId = recommentUserId;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTim() {
        return updateTim;
    }

    public void setUpdateTim(Date updateTim) {
        this.updateTim = updateTim;
    }
}
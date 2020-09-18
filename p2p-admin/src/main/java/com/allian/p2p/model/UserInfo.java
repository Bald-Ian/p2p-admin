package com.allian.p2p.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UserInfo implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Date createDate;

    private Integer loginCount;

    private Date lastLoginTime;

    private Integer staffId;

    private Integer available;

    private StaffInfo staffInfo;

    private PermissionInfo permissionInfo;

    private Map<String,String> urlMap = new HashMap<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getAvailable() {
        return available;
    }

    public UserInfo setAvailable(Integer available) {
        this.available = available;
        return this;
    }

    public PermissionInfo getPermissionInfo() {
        return permissionInfo;
    }

    public UserInfo setPermissionInfo(PermissionInfo permissionInfo) {
        this.permissionInfo = permissionInfo;
        return this;
    }

    public Map<String, String> getUrlMap() {
        return urlMap;
    }

    public UserInfo setUrlMap(Map<String, String> urlMap) {
        this.urlMap = urlMap;
        return this;
    }

    public StaffInfo getStaffInfo() {
        return staffInfo;
    }

    public UserInfo setStaffInfo(StaffInfo staffInfo) {
        this.staffInfo = staffInfo;
        return this;
    }
}
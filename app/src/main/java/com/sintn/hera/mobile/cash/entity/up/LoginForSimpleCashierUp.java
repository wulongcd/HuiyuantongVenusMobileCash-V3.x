package com.sintn.hera.mobile.cash.entity.up;

/**
 * 简单收银->登录上行实体
 */
public class LoginForSimpleCashierUp {
    // 用户名称
    private String username;

    // 密码
    private String password;

    public LoginForSimpleCashierUp() {
    }

    public LoginForSimpleCashierUp(String username, String password) {
        this.username = username;
        this.password = password;
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
}

package com.wuliangit.shopos.common.shiro.realm;

import org.apache.shiro.authc.AuthenticationToken;

import java.util.HashMap;

/**
 * 用于和其他用户区分开验证.
 */
public class UserToken implements AuthenticationToken {

    private String username;

    private UserType userType;

    private LoginType loginType;

    private char[] password;

    public enum UserType {
        ADMIN("admin"), MEMBER("member"), STORE("store");
        private final String type;

        private UserType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public enum LoginType {
        APP("app"), WEB("web"), WX("wx"), TOKEN("token"), ADMIN("admin"),STORE("store");
        private final String type;

        private LoginType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public UserToken(final String username, final String password, UserType userType, LoginType loginType) {
        this.username = username;
        this.loginType = loginType;
        this.userType = userType;
        this.password = (password != null ? password.toCharArray() : null);
    }

    @Override
    public Object getPrincipal() {
        HashMap<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("loginType", loginType);
        user.put("userType", userType);
        return user;
    }

    @Override
    public Object getCredentials() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public UserType getUserType() {
        return userType;
    }
}

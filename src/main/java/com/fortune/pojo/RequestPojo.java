package com.fortune.pojo;

/**
 * Created by admin on 2017/8/14.
 */
public class RequestPojo {
    private String userIdentity;

    public RequestPojo() {
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    @Override
    public String toString() {
        return "RequestPojo{" +
                "userIdentity='" + userIdentity + '\'' +
                '}';
    }
}

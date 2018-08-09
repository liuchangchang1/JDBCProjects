package cn.happy.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-8-9.
 */
public class Users implements Serializable{

    private Integer user_id; //用户ID
    private String userName;//用户名
    private String password;//用户名
    private String email;//email
    private Integer userType;//用户类型 0：管理员 1：普通用户

    public Users() {

    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id=" + user_id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userType=" + userType +
                '}';
    }

    public Users(Integer user_id) {
        this.user_id = user_id;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}

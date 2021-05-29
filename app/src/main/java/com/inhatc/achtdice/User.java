package com.inhatc.achtdice;

public class User {
    public String userId;
    public String userPassword;
    public String userName;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String userId,String userPassword,String userName, String email) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.email = email;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String UserId) {
        this.userId = UserId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.userPassword = UserPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userId + '\'' +
                "userpassword='" + userPassword + '\'' +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


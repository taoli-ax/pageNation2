package com.coh.service;

import com.coh.mapper.UserDao;
import com.coh.pojo.User;

import java.util.List;

public class UserService {

    private User user;
    private List<String> strings;



    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }
}

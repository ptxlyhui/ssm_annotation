package com.lyhui.service;

import com.github.pagehelper.PageInfo;
import com.lyhui.dto.ResponseCode;
import com.lyhui.model.User;

public interface UserService {
    void save(User user);

    User getUser(Integer id);

    void update(User user);

    ResponseCode deleteUser(Integer id);

    PageInfo<User> query(Integer pageNum, Integer pageSize);
}

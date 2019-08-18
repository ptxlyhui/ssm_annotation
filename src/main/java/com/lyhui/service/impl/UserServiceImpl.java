package com.lyhui.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyhui.dto.ResponseCode;
import com.lyhui.mapper.UserMapper;
import com.lyhui.model.User;
import com.lyhui.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public User getUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public ResponseCode deleteUser(Integer id) {
        ResponseCode code = new ResponseCode();
        int row = userMapper.deleteByPrimaryKey(id);
        if (row == 1) {
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("删除成功");
        } else {
            code.setCode(ResponseCode.FAIL);
            code.setMsg("删除失败");
        }
        return code;
    }

    @Override
    public PageInfo<User> query(Integer pageNum, Integer pageSize) {
        //分页查询
        PageHelper.startPage(pageNum, pageSize);//统计多少数据
        List<User> userList = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<> (userList);

        return pageInfo;
    }

}

package com.lyhui.mapper;

import com.lyhui.model.User;
import tk.mybatis.mapper.common.BaseMapper;

/*
* 配置了通用mapper后，继承BaseMapper
* 本接口就自动继承了增删改查的功能
* */
public interface UserMapper extends BaseMapper<User> {

}

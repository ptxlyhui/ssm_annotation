package com.lyhui.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data//使用Lombok，无需添加getter、setter
@NoArgsConstructor//添加无参构造器
@AllArgsConstructor//添加所有的有参构造器
public class User {

    //添加主键策略
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userName;

    private String password;

    private Date birth;
}

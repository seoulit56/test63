package com.seoulit.app.system.user;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;

/**
 * UserDao
 */
@Mapper
@Resource(name = "sqlSessionFactory")
public interface UserDao {

    public List<User> list();
    
}
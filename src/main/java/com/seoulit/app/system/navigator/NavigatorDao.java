package com.seoulit.app.system.navigator;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;

/**
 * NavigatorDao
 */
@Mapper
@Resource(name = "sqlSessionFactory")
public interface NavigatorDao {

    public List<Map<String, Object>> mainNavList();
    
}
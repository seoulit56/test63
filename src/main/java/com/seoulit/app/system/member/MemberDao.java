package com.seoulit.app.system.member;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;

/**
 * MemberDao
 */
@Mapper
@Resource(name = "sqlSessionFactory")
public interface MemberDao {

    public List<Member> list();
    
}
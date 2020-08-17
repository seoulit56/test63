package com.seoulit.app.system.domain;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Mapper;

/**
 * DomainDao
 */
@Mapper
@Resource(name = "sqlSessionFactory")
public interface DomainDao {

    public List<Domain> list();

    public Domain getDomain(String domainId);

    public List<DomainDetail> getDomainDetail(String domainId);
    
}
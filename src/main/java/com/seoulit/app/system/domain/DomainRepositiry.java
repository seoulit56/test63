package com.seoulit.app.system.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DomainRepositiry
 */
public interface DomainRepositiry extends JpaRepository<Domain, Integer>{

    Domain findByDomainId(String domainId);
    
}
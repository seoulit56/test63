package com.seoulit.app.system.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * DomainDetailRepositiry
 */
public interface DomainDetailRepositiry extends JpaRepository<DomainDetail, Integer>{

    List<DomainDetail> findByDomainIdAndKeyUsingTrueOrderByNoAsc(String domainId);
    
    List<DomainDetail> findByDomainIdOrderByNoAsc(String domainId);


}
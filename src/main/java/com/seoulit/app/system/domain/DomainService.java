package com.seoulit.app.system.domain;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DomainService {

    @Resource
    private DomainRepositiry domainRepositiry;

    @Resource
    private DomainDetailRepositiry domainDetailRepositiry;

    @Transactional
    ResponseEntity<?> add(Domain domian) {

        domian.setCreateId("hoya");
        domian.setUpdateId("hoya");

        domainRepositiry.save(domian);
        
        if(domian.getDomainDetail().size() != 0) {
            domian.getDomainDetail().forEach(row -> {
                row.setDomainId(domian.getDomainId());
                row.setCreateId("hoya");
                row.setUpdateId("hoya");
            });
            domainDetailRepositiry.saveAll(domian.getDomainDetail());
        }

        return ResponseEntity.ok().build();
        
    }

    @Transactional
    ResponseEntity<?> modify(Domain domian) {

        domian.setUpdateId("hoya");

        domainRepositiry.save(domian);
        
        if(domian.getDomainDetail().size() != 0) {
            domian.getDomainDetail().forEach(row -> {
                if(row.getStatus().equals("del")) {
                    domainDetailRepositiry.delete(row);
                } else if(row.getStatus().equals("add")) {
                    row.setDomainId(domian.getDomainId());
                    row.setCreateId("hoya");
                    row.setUpdateId("hoya");
                    domainDetailRepositiry.save(row);
                } else {
                    row.setUpdateId("hoya");
                    domainDetailRepositiry.save(row);
                }
            });
        }

        return ResponseEntity.ok().build();
        
    }
    
}
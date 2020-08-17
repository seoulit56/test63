package com.seoulit.app.system.domain;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping(value = DomainController.URL)
public class DomainController {

    public static final String URL = "/api/system/domain";

    @Resource
    private DomainRepositiry domainRepositiry;

    @Resource
    private DomainDetailRepositiry domainDetailRepositiry;

    @Resource
    private DomainService domainService;

    @Resource
    private DomainDao domainDao;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> list() {

        return ResponseEntity.status(HttpStatus.OK).body(domainDao.list());

    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> post(@RequestBody Domain domain) {

        if(ObjectUtils.isEmpty(domain)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    
        return domainService.add(domain);

    }

    @PutMapping 
    @ResponseBody
    public ResponseEntity<?> put(@RequestBody Domain domain) {

        if(ObjectUtils.isEmpty(domain)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return domainService.modify(domain);

    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        Optional<Domain> app = domainRepositiry.findById(id);

        Domain domain = app.get();

        List<DomainDetail> domainDetail =  domainDetailRepositiry.findByDomainIdAndKeyUsingTrueOrderByNoAsc(domain.getDomainId());

        if(domainDetail.size() == 0) {
            domainRepositiry.delete(domain);
            return ResponseEntity.ok().build();
        } else {
            return new ResponseEntity<String>("하위 데이터가 존재합니다", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> getDomain(@PathVariable("id") int id) {

        Optional<Domain> app = domainRepositiry.findById(id);

        String domainId = app.get().getDomainId();

        
        Domain result = domainDao.getDomain(domainId);

        // result.setDomainDetail(domainDao.getDomainDetail(domainId));

        result.setDomainDetail(domainDetailRepositiry.findByDomainIdAndKeyUsingTrueOrderByNoAsc(domainId));

        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @GetMapping(value = "/check")
    @ResponseBody
    public ResponseEntity<?> getDomain(@RequestParam("domainId") String domainId) {

        Boolean check = true;

        Domain domain = domainRepositiry.findByDomainId(domainId);
        
        if (domain == null) check = false;

        return ResponseEntity.status(HttpStatus.OK).body(check);

    }

    @GetMapping(value = "/detail")
    @ResponseBody
    public ResponseEntity<?> getDomainDetail(@RequestParam("domainId") String domainId) {

        List<DomainDetail> domainDetail = domainDetailRepositiry.findByDomainIdAndKeyUsingTrueOrderByNoAsc(domainId);
        
        return ResponseEntity.status(HttpStatus.OK).body(domainDetail);

    }    

    @GetMapping(value = "/detailAll")
    @ResponseBody
    public ResponseEntity<?> getDomainDetailAll(@RequestParam("domainId") String domainId) {

        List<DomainDetail> domainDetail = domainDetailRepositiry.findByDomainIdAndKeyUsingTrueOrderByNoAsc(domainId);
        
        return ResponseEntity.status(HttpStatus.OK).body(domainDetail);

    }    

}
package com.seoulit.app.system.member;


import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * MemberController
 */
@RestController
@RequestMapping(value = MemberController.URL)
public class MemberController {

    public static final String URL = "/api/member";

    @Resource
    private MemberRepositiry memberRepositiry;

    @Resource
    private MemberDao memberDao;

    @GetMapping
    @ResponseBody
    public ResponseEntity<?> list() {

        return ResponseEntity.status(HttpStatus.OK).body(memberDao.list());

    }

    @GetMapping(value="/test")
    @ResponseBody
    public ResponseEntity<?> jpaList() {

        return ResponseEntity.status(HttpStatus.OK).body(memberRepositiry.findById((long) 4));

    }
    
}
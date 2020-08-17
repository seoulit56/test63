package com.seoulit.app.system.navigator;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * NavigatorController
 */
@RestController
@RequestMapping(value = NavigatorController.URL)
public class NavigatorController {

    public static final String URL = "/api/system/navigator";

    @Resource
    private NavigatorRepositiry navigatorRepositiry;

    @Resource
    private NavigatorService navigatorService;

    @Resource
    private NavigatorDao navigatorDao;

    @GetMapping(value = "/main")
    @ResponseBody
    public ResponseEntity<?> mainNavList() {
 
        List<Map<String, Object>> mainNavList = navigatorService.mainNavList();
 
        return ResponseEntity.status(HttpStatus.OK).body(mainNavList);
 
    }
    
}
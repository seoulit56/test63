package com.seoulit.app.system.label;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * LabelController
 */
@RestController
@RequestMapping(value = LabelController.URL)
public class LabelController {

    public static final String URL = "/api/system/label";


    @Resource
    private LabelRepositiry labelRepositiry;



    @GetMapping(value = "/app")
    @ResponseBody
    public ResponseEntity<?> getDomain(@RequestParam("application") String application, @RequestParam("lang") String lang) {


        List<Label> label = labelRepositiry.findByApplicationAndLang(application, lang);

        Map<String, String> result = new HashMap<>();

        for(Label source : label) {
            result.put(source.getLabel(), source.getDescription());
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }
    
}
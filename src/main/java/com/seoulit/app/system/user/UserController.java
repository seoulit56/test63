package com.seoulit.app.system.user;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import com.seoulit.security.AES256Util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import common.api.SendSMSTwilio;

/**
 * UserController
 */
@RestController
@RequestMapping(value = UserController.URL)
public class UserController {

    public static final String URL = "/api/system/user";

    @Resource
    private UserRepositiry userRepositiry;

    @Resource
    private UserDao userDao;

    @Resource
    private AES256Util encryptors;


    @GetMapping
    @ResponseBody
    public ResponseEntity<?> list() {

        List<User> u = userDao.list();
        
        // String a = encryptors.encrypt(u.get(0).getTel());
        // System.out.println("encrypt" + a);
        // String b = encryptors.decrypt(a);
        // System.out.println("decrypt" + b);

        return ResponseEntity.status(HttpStatus.OK).body(u);

    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> getUser(@PathVariable("id") final int id) {

        return ResponseEntity.status(HttpStatus.OK).body(userRepositiry.findById(id));

    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> saveUser(@RequestBody final User user) {

        if(ObjectUtils.isEmpty(user)) return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();


        user.setPassword(encryptors.encrypt(user.getPassword()));
        user.setCreateId(user.getUserId());
        user.setUpdateId(user.getUserId());

        return ResponseEntity.status(HttpStatus.OK).body(userRepositiry.save(user));

    }

    @PutMapping(value="/{id}")
    @ResponseBody
    public ResponseEntity<?> updateUser(@PathVariable("id") final int id, @RequestBody final User request) {

        final Optional<User> app = userRepositiry.findById(id);

        final User user = app.get();

        user.setAddress(request.getAddress());
        
        return ResponseEntity.status(HttpStatus.OK).body(userRepositiry.save(user));

    }

    // @GetMapping(value = "/check")
    // @ResponseBody
    // public ResponseEntity<?> getUser(@RequestParam("userId") String userId) {

    //     Boolean check = true;

    //     User user = userRepositiry.findByUserId(userId);
        
    //     if (user == null) check = false;

    //     return ResponseEntity.status(HttpStatus.OK).body(check);

    // }


    @GetMapping(value = "/check")
    @ResponseBody
    public ResponseEntity<?> getUser(@RequestParam("col") String col, @RequestParam("param") String param) {

        Boolean check = true;
        User user = null;

        if (col.equals("userId")) user = userRepositiry.findByUserId(param);
        else if (col.equals("tel")) user = userRepositiry.findByTel(param);
        
        if (user == null) check = false;

        return ResponseEntity.status(HttpStatus.OK).body(check);

    }

    @GetMapping(value = "/test")
    @ResponseBody
    public ResponseEntity<?> getSms(@RequestParam("phone") String phone) {

        return ResponseEntity.status(HttpStatus.OK).body(SendSMSTwilio.sendSMS(phone));

    }
        
}
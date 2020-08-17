package com.seoulit.app.system.user;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepositiry
 */
public interface  UserRepositiry extends JpaRepository<User, Integer>{

    User findByUserId(String userId);

    User findByTel(String tel);
    
}
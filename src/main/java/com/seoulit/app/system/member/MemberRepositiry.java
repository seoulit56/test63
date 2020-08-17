package com.seoulit.app.system.member;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MemberRepositiry
 */
public interface  MemberRepositiry extends JpaRepository<Member, Long>{

    
}
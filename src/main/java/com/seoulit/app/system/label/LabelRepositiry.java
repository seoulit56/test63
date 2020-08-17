package com.seoulit.app.system.label;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * LabelRepositiry
 */
public interface LabelRepositiry extends JpaRepository<Label, Integer>{

    List<Label> findByApplicationAndLang(String application, String lang);
    
}
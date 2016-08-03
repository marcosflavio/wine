package com.marcosf.wine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcosf.wine.model.Vinho;

public interface Vinhos extends JpaRepository<Vinho, Long>{
	
}

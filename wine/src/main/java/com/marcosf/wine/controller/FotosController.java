package com.marcosf.wine.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marcosf.wine.dto.Fotos;


//Porque facilita a escrita dos métodos para trabalhar com json, que eh o que o javascript entende.
//converte os dados para json
@RestController
@RequestMapping("/fotos")
public class FotosController {
	
	@RequestMapping(method = RequestMethod.POST)
	public Fotos upload(@RequestParam("files[]")MultipartFile[] files){
		
		
		return new Fotos (files[0].getOriginalFilename());
	}

}

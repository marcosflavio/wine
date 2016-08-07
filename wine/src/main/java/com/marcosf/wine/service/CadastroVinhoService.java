package com.marcosf.wine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcosf.wine.model.Vinho;
import com.marcosf.wine.repository.Vinhos;

@Service
public class CadastroVinhoService {

	@Autowired
	private Vinhos vinhoRep;
	
	
	public void salvar(Vinho vinho){
		//Escrever regras de negócio
		this.vinhoRep.save(vinho);
	}
	
}

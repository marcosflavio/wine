package com.marcosf.wine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.marcosf.wine.model.TipoVinho;
import com.marcosf.wine.model.Vinho;
import com.marcosf.wine.repository.Vinhos;
import com.marcosf.wine.service.CadastroVinhoService;

@Controller
@RequestMapping("/vinhos")
public class VinhosController {

	@Autowired
	private Vinhos vinhos;
	
	@Autowired
	private CadastroVinhoService cadastroVinhoService;
	
	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/vinho/ListagemVinhos");
		List<Vinho> vinhosList = vinhos.findAll();
		mv.addObject("vinhos", vinhosList);
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo(Vinho vinho) {
		ModelAndView mv = new ModelAndView("/vinho/CadastroVinho"); //agora eu passo o objeto vinho para a minha view
		mv.addObject("tipos", TipoVinho.values());
		return mv;
	}
	
	 //ele tem o mesmo request mapping, porém, é do método Post, pois iremos
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salva(Vinho vinho) {

		 
		cadastroVinhoService.salvar(vinho);
		
		return new ModelAndView("redirect:/vinhos/novo");

	}

}

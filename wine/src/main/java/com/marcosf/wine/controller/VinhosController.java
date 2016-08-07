package com.marcosf.wine.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public ModelAndView salva(@Valid Vinho vinho, BindingResult result, RedirectAttributes attributes) {
		//redirect atributes é pra enviar alguma coisa ao redirecionamento
		if(result.hasErrors()){
			
			return novo(vinho); //retorno novamente pro request mapping novo passando objeto vinho, para que a página
								//redenrize com os dados do vinho que já foram preenchidos anteriormente.
		}
		 
		cadastroVinhoService.salvar(vinho);
		attributes.addFlashAttribute("mensagemSucesso", "Vinho salvo com sucesso!");
		
		return new ModelAndView("redirect:/vinhos/novo");

	}

}

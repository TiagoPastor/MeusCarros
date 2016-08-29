package com.pastor.projeto.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pastor.projeto.model.Carro;
import com.pastor.projeto.model.TipoCarro;
import com.pastor.projeto.repository.Carros;
import com.pastor.projeto.service.CadastroCarroService;
import com.pastor.projeto.storage.FotoStorage;

@Controller
@RequestMapping("/carros")
public class CarrosController {

	@Autowired
	private Carros carros;
	
	@Autowired
	private FotoStorage fotoStorage;
	
	@Autowired
	private CadastroCarroService cadastroCarroService;
	
	@RequestMapping
	public ModelAndView pesquisa() {
		ModelAndView mv = new ModelAndView("/carro/ListagemCarros");
	   mv.addObject("carros", carros.findAll());
		return mv;
	}
	
	@RequestMapping("/novo")
	public ModelAndView novo( Carro carro) {
		ModelAndView mv = new ModelAndView("/carro/CadastroCarro");
		 mv.addObject("tipos", TipoCarro.values());
		 return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Carro carro, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
			return novo(carro);
		}
		cadastroCarroService.salvar(carro);
		attributes.addFlashAttribute("mensagem", "Carro salvo com sucesso!");
		return new ModelAndView("redirect:/carros/novo");
		
	}
	
	@RequestMapping("/{codigo}")
	public ModelAndView visualizar(@PathVariable("codigo") Carro carro){
		ModelAndView mv = new ModelAndView("/carro/VisualizacaoCarro");
		
		if(carro.temFoto()){
		 carro.setUrl(fotoStorage.getUrl(carro.getFoto()));
		}
		 
		mv.addObject("carro", carro);
		return mv; 
		
	}
	
}

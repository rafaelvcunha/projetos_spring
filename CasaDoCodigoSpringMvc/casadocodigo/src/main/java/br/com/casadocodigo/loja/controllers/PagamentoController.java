package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;

@Controller
@RequestMapping("/pagamento")
//@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {

	@Autowired
	CarrinhoCompras carrinho;
	
	@RequestMapping(value= "/finalizar", method=RequestMethod.POST)
	public ModelAndView finalizar(RedirectAttributes redirectAttributes){
		System.out.println(carrinho.getTotal());
		
		redirectAttributes.addFlashAttribute("sucesso","Pagamento realizado com sucesso");
		
		return new ModelAndView("redirect:/produtos");
	}
	

}

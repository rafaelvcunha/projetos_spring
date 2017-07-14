package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.CarrinhoCompras;

@Controller
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	CarrinhoCompras carrinho;
	
	public ModelAndView finalizar(){
		System.out.println(carrinho.getTotal());
		return new ModelAndView("redirect:/produtos");
	}
}

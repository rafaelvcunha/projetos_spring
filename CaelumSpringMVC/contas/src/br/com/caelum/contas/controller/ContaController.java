package br.com.caelum.contas.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {
	
	@RequestMapping(value = "/form")
	public String form(){
		return "formulario";
	}	
	
	@RequestMapping("/adicionaConta")
	public String adiciona(Conta conta){
		
		ContaDAO dao = new ContaDAO();
		dao.adiciona(conta);
		
		return "conta/conta-adicionada";
	}
	
	
	@RequestMapping("/listaContas")
	public String lista(Model mv) {
	  ContaDAO dao = new ContaDAO();
	  List<Conta> contas = dao.lista();

	  mv.addAttribute("todasContas", contas);
	  return "conta/lista";
	}
	
	/*
	@RequestMapping("/listaContas")
	public ModelAndView lista(){
		
		ContaDAO dao = new ContaDAO();
		List<Conta> contas = dao.lista();
		
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("todasContas", contas);
		
		return mv;	
	}*/
	


}

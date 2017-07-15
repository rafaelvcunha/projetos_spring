package br.com.casadocodigo.loja.controllers;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.DadosPagamento;

@Controller
@RequestMapping("/pagamento")
//@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CarrinhoCompras carrinho;
	
	@RequestMapping(value= "/finalizar", method=RequestMethod.POST)
	public Callable<ModelAndView> finalizar(RedirectAttributes redirectAttributes){
		return () ->{
			try {
				System.out.println(carrinho.getTotal());
				
				String uri = "http://book-payment.herokuapp.com/payment";
				
				String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);
				
				System.out.println(response);
				
				redirectAttributes.addFlashAttribute("sucesso", response);
				carrinho.limparCarrinho();
				return new ModelAndView("redirect:/produtos");
				
			} catch (HttpClientErrorException e) {
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("falha", "Valor maior que o permitido!");	
				carrinho.limparCarrinho();
				return new ModelAndView("redirect:/produtos");
			}	
		};
	}
	

}

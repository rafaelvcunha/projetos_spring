package br.com.casadocodigo.loja.conf;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.controllers.ProdutosController;
import br.com.casadocodigo.loja.daos.ProdutoDAO;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, ProdutosController.class, ProdutoDAO.class})
public class AppWebConfiguration {
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
	
		InternalResourceViewResolver resolve = new InternalResourceViewResolver();
		resolve.setPrefix("/WEB-INF/views/");
		resolve.setSuffix(".jsp");
		
		return resolve;
	}
	
	@Bean
	public MessageSource messageSource(){
		
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		
		messageSource.setBasename("/WEB-INF/messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(1);
		
		return messageSource;
	}

}

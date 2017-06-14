package br.com.caelum.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class LoginController {

	@RequestMapping("loginForm")
	public String loginForm(){
		return "login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session){
		
		if(new UsuarioDAO().existeUsuario(usuario)){
			//usuario existe e eh guardado na session
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		}
		//Senha incorreta, volta para a tela de login
		return "login";
	}
	
	@RequestMapping("deslogar")
	public String deslogar(HttpSession session){
		session.invalidate();
		return "redirect:loginForm";
	}
	
}

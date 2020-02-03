package br.com.rafaelvcunha.springbootstart;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
@RequestMapping("/")
public class HelloWorld {
	
	@GetMapping
	public String sayHello() {
		return "Hello from SpringBoot by RafaelVCunha!!!";
	}
	
	@GetMapping("/subpath")
	public String subPath() {
		return "this is a subpath of endpont /";
	}
	
	@GetMapping("/{dynamic}")
	public String dynamicSubPath( @PathVariable("dynamic") String name) {
		return "Hello " + name + " this is my route dynamic...";
	}
	
	@GetMapping("/querystring")//não preenchendo o parametro name, sem o required, apresenta erro
	public String querystring( @RequestParam(value = "name", required = false) String name) {
		return "this is a subpath of endpont with Query String/" + name;
	}
	
	@GetMapping("/querystringwr")//não apresenta erro, caso o parametro name não esteja preenchido
	@ResponseBody
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public String querystringwr( final WebRequest webRequest) {
		String name = webRequest.getParameter("name");
		return "this is a subpath of endpont with Query String/" + name;
	}
	
	//@PostMapping("/post")
	@PostMapping(value = "/post", produces = MediaType.APPLICATION_JSON_VALUE)
	public String sayHelloPost(@RequestBody Map<String, Object> payload) {
		return payload.get("name").toString();
	}
	
	

}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livros de java, Android, Iphone, PHP, Ruby e muito mais - Casa do código</title>
<c:url value="/resources/css" var="cssPath" />
<c:url value="/resources/js" var="jsPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
<script src="${cssPath}/bootstrap.min.js"></script>
<style type="text/css">
        body{
            padding-bottom: 60px;
        }
</style>
</head>
<body>
	
	<nav class="navbar navbar-inverse">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="${s:mvcUrl('HC#index').build()}">Casa do Código</a>
	    </div>
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      	<ul class="nav navbar-nav">
	        	<li><a href="${s:mvcUrl('PC#listar').build()}">Lista de Produtos</a></li>
	        	<li><a href="${s:mvcUrl('PC#form').build()}">Cadastro de Produtos</a></li>
	    	</ul>
	    	<ul class="nav navbar-nav navbar-right">
				<li>
				    <a href="#">
				        <security:authentication property="principal" var="usuario"/>
				        Usuário: ${usuario.username}
					</a>
				</li>
			</ul>
	    
	    </div><!-- /.navbar-collapse -->
	  </div>
	</nav>
	
	<div class="container">
	
	<h1> Produtos listados </h1>
	
	<div> ${sucesso}</div>
	<div> ${falha}</div>
	
	<table class="table table-bordered table-striped table-hover">
	
	<tr>
		<td>Título</td>
		<td>Descrição</td>
		<td>Preços</td>
		<td>Páginas</td>
	</tr>
	
	<c:forEach items="${produtos }" var="produto">
		<tr>
			<td>
				<a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}">${produto.titulo}</a>
			</td>
			<td>${produto.descricao}</td>
			<td>${produto.precos }</td>
			<td>${produto.paginas}</td>
		</tr>
	</c:forEach>
	
	
	
	</table>
	
	</div>
</body>
</html>
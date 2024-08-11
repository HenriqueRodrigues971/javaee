<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@ SuppressWarnings ("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");

%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda - Main</title>
<link rel="icon" href="imagens/phone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de contato</h1>
	<a href="novo.html" class="Botao1">Novo contato</a>
	<a href="report" class="Botao2" target="_Blank">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Email</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (JavaBeans jv : lista) {
			%>
			<tr>
				<td><%=jv.getId()%></td>
				<td><%=jv.getNome()%></td>
				<td><%=jv.getPhone()%></td>
				<td><%=jv.getEmail()%></td>
			<td><a href="select?id=<%=jv.getId() %>" class="Botao1">Editar</a>
			<a href="javascript: confirmar(<%=jv.getId() %>)" class="Botao2">Remover</a>
			</td>
			</tr>
			<%}%>
		</tbody>
	</table>
	<script type="text/javascript" src="scripts/confirmador.js"></script>
</body>
</html>
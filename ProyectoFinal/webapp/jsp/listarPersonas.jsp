<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>
	<%@include file='../templates/banner_inside.html'%>
	
	<div class="contenedor">
	<h1>Listado de Personas</h1>
	
	<div class="barra-comandos">
	<a class="btn-action" href="GestionarPersonaController?ruta=nuevo">Nuevo</a>
	</div>
	
	
    
	<table class="table">
	<thead>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Correo electrónico</th>
			<th>Departamento</th>
			<th>Acciones</th>
		</tr>
	</thead>

		<c:forEach var="persona" items="${personas}">
			<tr>
				<td scope="row">${persona.id}</td>
				<td>${persona.nombre}</td>
				<td>${persona.correo}</td>
				<td>${persona.departamento.nombre}</td>
				<td class="txt-center">
				<a href="GestionarPersonaController?ruta=actualizar&idPersona=${persona.id}">Cambiar Clave</a> | 
				<a href="GestionarPersonaController?ruta=eliminar&idPersona=${persona.id}">Eliminar</a> |
				</td>
			</tr>
		</c:forEach>

	</table>
	</div>
</body>
</html>
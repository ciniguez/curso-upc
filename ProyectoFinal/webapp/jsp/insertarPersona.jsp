<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insertar Persona</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />
</head>
<body>


	<%@include file='../templates/banner_inside.html'%>


	<div class="wrapper">
	<div id="formContent">
		

		<form method="POST" action="GestionarPersonaController?ruta=guardar">
		<fieldset>
		<h1>Insertar Persona</h1>
			<!--label for="txtId">Id</label-->
			<input type="hidden" name="txtId" id="txtId" />
			
			<label>Departamento</label>
			<select name="idDepartamento">
			
			<option value="-1">Seleccione ...</option>
			<c:forEach items="${departamentos}" var="opcion">
			<option value="${opcion.id}">${opcion.nombre}</option>
			</c:forEach>
			
			</select>
			
			<label for="txtNombre">Nombre</label>
			<input type="text" name="txtNombre" id="txtNombre" required /> 
			
			<label for="txtClave">Clave</label>
			<input type="password" name="txtClave" id="txtClave" required pattern="[a-zA-Z0-9]{4,16}"/>
			
			<label for="txtCorreo">Correo electrónico</label>
			<input type="email" name="txtCorreo" id="txtCorreo" placeholder="Ingrese su correo electrónico" required /> 
			
			<div class="acciones-formulario">
				<a class="btn-action btn-cancelar" href="GestionarPersonaController?ruta=listar">Cancelar</a>
				<input type="submit" value="Guardar">
			</div>
		</fieldset>
		</form>
</div>

	</div>
</body>
</html>
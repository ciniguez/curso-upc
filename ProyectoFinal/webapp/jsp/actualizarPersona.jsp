<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Actualizar</title>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css" />


</head>
<body>
	<%@include file='../templates/banner_inside.html'%>

	<div class="wrapper">
		<div id="formContent">

			<form method="POST" action="GestionarPersonaController?ruta=changepass">
				<legend>Actualizar Persona</legend>
				<fieldset>
					<input type="hidden" value="${persona.id}" name="txtId" /> 
					
					<label for="txtNombre">Nombre</label>
						
					<input type="text" name="txtNombre" id="txtNombre" value="${persona.nombre}" /> 
					
					<label for="txtClave">Clave</label>
					<input type="text" name="txtClave" id="txtClave" value="${persona.password}" />
					
					<div class="acciones-formulario">
						<input type="submit" value="Guardar"> 
						<a class="btn-action btn-cancelar" href="GestionarPersonaController?ruta=listar">Cancelar</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</body>


</html>
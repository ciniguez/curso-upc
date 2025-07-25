<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<!-- link rel="stylesheet" href="../css/estilos.css" -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />

</head>
<body>


<%@include file='../templates/banner.html'%>


	<div class="wrapper">
		<div id="formContent">

			<!-- Login Form -->
			<form action="../LoginController?ruta=ingresar" method="POST">
				<fieldset>
					<legend>Bienvenido!</legend>
					<label>Usuario</label>
					<input type="text" name="usuario" placeholder="nombre de usuario" required/>
					<label>Contraseña</label>	
					<input type="password" name="password" placeholder="contraseña" required pattern="[a-zA-Z0-9]{4,16}"/>

						
					<div class="acciones-formulario">
						<input type="submit" value="Ingresar" />
					</div>
				</fieldset>
			</form>


		</div>
	</div>





	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
		crossorigin="anonymous"></script>
</body>
</html>
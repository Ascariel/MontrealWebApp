<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>





<div class="container">


	<div class="row">
		<div class="col-md-12 text-center">
			<h3>Crear Cuenta Alumno</h3>
			<hr>
		</div>

		<div class="col-md-6 offset-md-3">
			<form:form method="POST" action="/crear-alumno"
				modelAttribute="alumnoDTO">
				<form:input path="usuarioDTO.perfilDTO.nombre" type="hidden"
					class="form-control" required="required" />

				<div class="form-group">
					<label>Usuario</label>
					<form:input path="usuarioDTO.usuario" maxlength="30" minlength="3" type="text"
						class="form-control" required="required" />
				</div>

				<div class="form-group">
					<label>Contraseña</label>
					<form:input path="usuarioDTO.clave" maxlength="30" minlength="8" type="text"
						class="form-control" required="required" />
				</div>


				<div class="form-group">
					<label>Correo Electrónico</label>
					<form:input path="correo" type="email" class="form-control"
						maxlength="40" minlength="3" placeholder="Formato ej: email@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" required="required" />
				</div>


				<div class="row">
					<div class="form-group col-md-6">
						<div class="form-group">
							<label>Nombre</label>
							<form:input path="nombre" maxlength="30" minlength="3" type="text" class="form-control"
								required="required" />
						</div>
											

					</div>

					<div class="form-group col-md-6">
						<div class="form-group">
							<label>Apellidos</label>
							<form:input path="apellidos" maxlength="40" minlength="3" type="text" class="form-control"
								required="required" />
						</div>					

					</div>

					<div class="form-group col-md-6">
						<div class="form-group">
							<label>RUT</label>
							<form:input path="rut" type="text" class="form-control" id="rut" 
								required="required" onkeyup="checkRut()" onblur="checkRut()" placeholder="Rut sin puntos ni guiones"/>
						</div>
					</div>

					<div class="form-group col-md-6">
						<div class="form-group">
							<label>Fecha de Nacimiento</label>
							<form:input path="fechaNacimiento" type="text"
								class="form-control" required="required" placeholder="Elegir..."
								 onkeyup="this.value=''" autocomplete="off" />
						</div>
					</div>
				</div>


				<button type="submit" class="btn btn-primary btn-md btn-block">Registrar
					Cuenta</button>
			</form:form>
		</div>





	</div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"
      integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>      
<script
	src="/webjars/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
<link rel="stylesheet"
	href="/webjars/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.css"></link>


<script>
	$('#fechaNacimiento').datepicker({
		format : 'dd-mm-yyyy',
		autoclose: true,
		defaultViewDate: '01-01-1995',
		startDate: "01-01-1918",
		endDate: "01-01-2005"
	});
	


	function checkRut() {
	    // Despejar Puntos
	    var  rut = $("#rut")[0];
	    
	    if (rut.length == 0){
	    	 return null;
	    }
	    
	    var valor = rut.value.replace('.','');
	    valor = valor.replace('-','');
	    
	    // Aislar Cuerpo y Dígito Verificador
	    cuerpo = valor.slice(0,-1);
	    dv = valor.slice(-1).toUpperCase();
	    
	    // Si no cumple con el mínimo ej. (n.nnn.nnn)
	    if(cuerpo.length < 7) { rut.setCustomValidity("RUT Incompleto"); return false;}
	    
	    // Calcular Dígito Verificador
	    suma = 0;
	    multiplo = 2;
	    
	    // Para cada dígito del Cuerpo
	    for(i=1;i<=cuerpo.length;i++) {
	    
	        // Obtener su Producto con el Múltiplo Correspondiente
	        index = multiplo * valor.charAt(cuerpo.length - i);
	        
	        // Sumar al Contador General
	        suma = suma + index;
	        
	        // Consolidar Múltiplo dentro del rango [2,7]
	        if(multiplo < 7) { multiplo = multiplo + 1; } else { multiplo = 2; }
	  
	    }
	    
	    // Calcular Dígito Verificador en base al Módulo 11
	    dvEsperado = 11 - (suma % 11);
	    
	    // Casos Especiales (0 y K)
	    dv = (dv == 'K')?10:dv;
	    dv = (dv == 0)?11:dv;
	    
	    // Validar que el Cuerpo coincide con su Dígito Verificador
	    if(dvEsperado != dv) { rut.setCustomValidity("RUT Inválido. (Asegurese de no usar puntos ni guiones)"); return false; }
	    
	    // Si todo sale bien, eliminar errores (decretar que es válido)
	    rut.setCustomValidity('');
	}	
		
</script>


<%@ include file="/WEB-INF/jsp/shared/footer.jspf"%>
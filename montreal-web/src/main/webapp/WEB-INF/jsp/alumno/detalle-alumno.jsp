<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>





<div class="container">


  <div class="row">
    <div class="col-md-12 text-center">
      <h3>Perfil Alumno</h3>
      <hr>
    </div>

    <div class="col-md-6 offset-md-3">
      <form:form method="GET" action="" modelAttribute="alumnoDTO">
<!--         <input name="_method" type="hidden" value="patch" /> -->

        <form:input path="usuarioDTO.perfilDTO.nombre" type="hidden" class="form-control" required="required"/>
        <div class="form-group">
          <label>Usuario</label>
          <form:input class="form-control" maxlength="30" minlength="3" path="usuarioDTO.usuario"  readonly="true"></form:input>
        </div>        

        <div class="form-group">
          <label >Nombre Alumno</label> 
          <form:input path="nombre" type="text" maxlength="30" minlength="3" class="form-control" readonly="true" required="required"/>
        </div>
        
        <div class="form-group">
          <label >Apellidos</label> 
          <form:input path="apellidos"  maxlength="40" minlength="3" type="text" class="form-control"  readonly="true" required="required"/>
        </div>        

        <div class="row">
          <div class="form-group col-md-6">
            <div class="form-group">
              <label>Correo Electronico</label> 
              <form:input path="correo" type="email" class="form-control"
						maxlength="40" minlength="3" placeholder="Formato ej: email@gmail.com" readonly="true" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" required="required" />
            </div>
          </div>
          
          <div class="form-group col-md-6">
            <div class="form-group">
              <label>Contrasena</label> 
                <form:input path="usuarioDTO.clave" value="*********" maxlength="30" minlength="8" type="password" class="form-control" readonly="true" required="required"/>
            </div>
          </div>          

          <div class="form-group col-md-6">
            <div class="form-group">
              <label>RUT</label> 
              <form:input path="rut" type="text" class="form-control" required="required" readonly="true"/>
            </div>
          </div>

          <div class="form-group col-md-6">
            <div class="form-group">
              <label>Fecha de Nacimiento</label> 
<%--               <form:input path="fechaNacimiento" type="text" class="form-control" required="required"/> --%>
			  <form:input path="fechaNacimiento" type="text" onkeyup="this.value=''" placeholder="Elegir..."
								class="form-control" required="required"  readonly="true" autocomplete="off"  />              
            </div>
          </div>
        </div>


        <a href="${ urlLanding }" class="btn btn-warning btn-md btn-block">Volver</a>



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
		startDate: "01-01-1918"	
		
	});
	
	
</script>


<%@ include file="/WEB-INF/jsp/shared/footer.jspf"%>
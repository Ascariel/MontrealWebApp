<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>


<div class="container">


  <div class="row">
    <div class="col-md-12 text-center">
    <h3>Detalles Centro de Estudio Local</h3>
    <hr>
  </div>

  <div class="col-md-6 offset-md-3">
    <form:form method="POST" action="/cel/editar-cel" modelAttribute="celDTO">
	  <form:input path="usuarioDTO.perfilDTO.nombre" type="hidden" class="form-control" required="required"/>
	  
      <div class="form-group">
        <label>Usuario</label>
        <form:input path="usuarioDTO.usuario" type="text" maxlength="30" minlength="3" class="form-control" readonly="true" required="required"/>
      </div>
      	  
      <div class="form-group">
        <label>Nombre Institución</label>
        <form:input path="nombre" type="text" maxlength="30" minlength="3" class="form-control" required="required"/>
   
      </div>
      
        <div class="form-group">
          <label >Contraseña</label> 
          <form:input path="usuarioDTO.clave" type="text" maxlength="30" minlength="8" class="form-control" required="required"/>
        </div>      

      <div class="form-group">
        <label>País</label>
        <select class="form-control" name='programa_estudio[pais_id]' disabled >
            <option value="">Chile</option>
        </select>
        
		<form:input path="paisDTO.id" value="1" type="hidden" class="form-control"/>
		<form:input path="paisDTO.pais" value="Chile" type="hidden" class="form-control"/>        
      </div>
      
      <div class="form-group">
        <label>Dirección</label>
        <form:input path="direccion" type="text" maxlength="45" minlength="5" class="form-control" required="required"/>
      </div>
      

      <div class="row">
        <div class="form-group col-md-6">
          <div class="form-group">
            <label>Teléfono de Contacto</label>
            <form:input path="telefono" type="number"  class="form-control" required="required"/>
          </div>
        </div>

        <div class="form-group col-md-6">
          <div class="form-group">
            <label>Correo Electronicós</label>
            <form:input path="correo" type="email" class="form-control"
						maxlength="40" minlength="3" placeholder="Formato ej: email@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" required="required" />
          </div>
        </div>
      </div>
      
      <button type="submit" class="btn btn-primary btn-md btn-block">Guardar Cambios</button>
     
    </form:form>
  </div>





  </div>
</div>


<%@ include file="/WEB-INF/jsp/shared/footer.jspf"  %>
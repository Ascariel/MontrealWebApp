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
      <form:form method="POST" action="/familia/postular-cel" modelAttribute="celDTO">
      <form:input path="usuarioDTO.perfilDTO.nombre" type="hidden" class="form-control" required="required"/>
      <form:input path="usuarioDTO.usuario" type="hidden" class="form-control" required="required"/>
      <form:input path="id" type="hidden" class="form-control" required="required"/>
      
      <div class="form-group">
        <label>Nombre Institución</label>
        <form:input path="nombre" type="text" class="form-control" required="required" readonly="true"/>
      </div>

      <div class="form-group">
        <label>País</label>
        <select class="form-control" name='programa_estudio[pais_id]' disabled >
            <option value=""  >${celDTO.paisDTO.pais}</option>
        </select>
      </div>
      
      <div class="form-group">
        <label>Dirección</label>
         <form:input path="direccion" type="text" class="form-control" required="required" readonly="true"/>
      </div>
      

      <div class="row">
        <div class="form-group col-md-6">
          <div class="form-group">
            <label>Teléfono de Contacto</label>
            <form:input path="telefono" type="text" class="form-control" required="required" readonly="true"/>
          </div>
        </div>

        <div class="form-group col-md-6">
          <div class="form-group">
            <label>Correo Electrónico</label>
            <form:input path="correo" type="text" class="form-control" required="required" readonly="true"/>
          </div>
        </div>
      </div>
      
	<c:if test="${postulacionExistente == true}">
		<button type="submit" class="btn btn-primary btn-md btn-block" disabled> Postulación Realizada</button>
		<a href="/familia/listado-cel-postulables" class="btn btn-warning btn-md btn-block"> Volver</a>
	</c:if>
	<c:if test="${postulacionExistente != true}">
		<button type="submit" class="btn btn-primary btn-md btn-block"> Postular A Centro Local</button>
	</c:if>
		

    </form:form>
  </div>





  </div>
</div>


<%@ include file="/WEB-INF/jsp/shared/footer.jspf"  %>
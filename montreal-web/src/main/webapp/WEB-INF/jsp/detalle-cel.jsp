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
    <form method="POST" action="/">
      <input name="_method" type="hidden" value="patch" />
      <div class="form-group">
        <label>Nombre Institución</label>
        <input type="text" class="form-control" name="programa_estudio[nombre]" value="${celDTO.nombre}"  disabled required >
      </div>

      <div class="form-group">
        <label>País</label>
        <select class="form-control" name='programa_estudio[pais_id]' disabled >
            <option value=""  >${celDTO.paisDTO.pais}</option>
        </select>
      </div>
      
      <div class="form-group">
        <label>Dirección</label>
        <input type="text" class="form-control" name="programa_estudio[nombre]" value="${celDTO.direccion}"  disabled required >
      </div>
      

      <div class="row">
        <div class="form-group col-md-6">
          <div class="form-group">
            <label>Teléfono de Contacto</label>
            <input type="text" class="form-control" name="programa_estudio[max_cupos]" value="${celDTO.telefono}"  required disabled >
          </div>
        </div>

        <div class="form-group col-md-6">
          <div class="form-group">
            <label>Correo Electrónico</label>
            <input type="text" class="form-control" name="programa_estudio[min_cupos]" value="${celDTO.correo}"  required disabled >
          </div>
        </div>
      </div>
      
      <c:if test="${ perfil.equals(\"CEL\") }">
        <a type="submit" href="/cel/editar-cel?id=${celDTO.id }" class="btn btn-primary btn-md btn-block">Editar</a>
      </c:if>
      
      <c:if test="${ perfil.equals(\"FAMILIA\") }">
        <a href="/familia/postular-cel?id=${celDTO.id }" class="btn btn-primary btn-md btn-block">Postular</a>
      </c:if>      

      
    </form>
  </div>





  </div>
</div>


<%@ include file="/WEB-INF/jsp/shared/footer.jspf"  %>
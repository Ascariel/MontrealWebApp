<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>





<div class="container">


  <div class="row">
    <div class="col-md-12 text-center">
      <h3>Crear Cuenta Familia</h3>
      <hr>
    </div>

    <div class="col-md-6 offset-md-3">
      <form:form method="POST" action="/crear-familia" modelAttribute="familiaDTO">
        <form:input path="usuarioDTO.perfilDTO.nombre" type="hidden" class="form-control" required="required"/>
      
        <div class="form-group">
          <label >Usuario</label> 
          <form:input path="usuarioDTO.usuario" maxlength="30" minlength="3" type="text" class="form-control" required="required"/>
        </div>
        
        <div class="form-group">
          <label >Contraseña</label> 
          <form:input path="usuarioDTO.clave" maxlength="30" minlength="8" type="text" class="form-control" required="required"/>
        </div>
                      
        <div class="form-group">
          <label >Nombre</label> 
          <form:input path="nombreFamilia" maxlength="30" minlength="3" type="text" class="form-control" required="required"/>
        </div>
        
        <div class="form-group">
          <label >Apellidos</label> 
          <form:input path="apellidoFamilia" maxlength="30" minlength="3" type="text" class="form-control" required="required"/>
        </div>        

        <div class="row">
          <div class="form-group col-md-6">
            <div class="form-group">
              <label>Teléfono </label> 
			  <form:input path="telefono" type="number" min="9999999" max="999999999999" class="form-control" required="required"/>
            </div>
          </div>

          <div class="form-group col-md-6">
            <div class="form-group">
              <label>Correo Electrónico</label> 
               <form:input path="correo" maxlength="40" minlength="3" placeholder="Formato ej: email@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" class="form-control" required="required"/>
            </div>
          </div>

          <div class="form-group col-md-6">
            <div class="form-group">
              <label>Dirección</label> 
               <form:input path="direccion" maxlength="49" minlength="3" type="text" class="form-control" required="required"/>
            </div>
          </div>

          <div class="form-group col-md-6">
            <div class="form-group">
              <label>País</label> 
				<form:input path="paisDTO.id" value="1" type="hidden" class="form-control"/>
				<form:input path="paisDTO.pais" value="Inglaterra" type="hidden" class="form-control"/>
               <input type="text" value="Inglaterra" class="form-control"/>
            </div>
          </div>
        </div>


        <button type="submit" class="btn btn-primary btn-md btn-block">Registrar Cuenta</button>
      </form:form>
    </div>





  </div>
</div>


<%@ include file="/WEB-INF/jsp/shared/footer.jspf"%>
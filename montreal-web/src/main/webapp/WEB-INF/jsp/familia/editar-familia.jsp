<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>





<div class="container">


  <div class="row">
    <div class="col-md-12 text-center">
      <h3>Editar Familia</h3>
      <hr>
    </div>

    <div class="col-md-6 offset-md-3">
      <form:form method="POST" action="/editar-familia" modelAttribute="familiaDTO">
        <form:input path="usuarioDTO.perfilDTO.nombre" type="hidden" class="form-control" required="required"/>
        
        <div class="form-group">
          <label >Usuario</label> 
          <form:input path="usuarioDTO.usuario" maxlength="30" minlength="3"  type="text" class="form-control" required="required" readonly="true"/>
          
        </div>
        
        <div class="form-group">
          <label >Contraseña</label> 
          <form:input path="usuarioDTO.clave" maxlength="30" minlength="1"  type="text" class="form-control" required="required"/>
<%--           <form:errors class="text-danger" path="usuarioDTO.clave"></form:errors> --%>
        </div>
                      
        <div class="form-group">
          <label >Nombre Representante</label> 
          <form:input path="nombreFamilia" type="text" minlength="3" maxlength="30" class="form-control" required="required"/>
<%--           <form:errors class="text-danger" path="nombreFamilia"></form:errors> --%>
        </div>
        
        <div class="form-group">
          <label >Apellidos Representante</label> 
          <form:input path="apellidoFamilia" type="text" minlength="3"  maxlength="30" class="form-control" required="required"/>
<%--           <form:errors class="text-danger" path="apellidoFamilia"></form:errors> --%>
        </div>        

        <div class="row">
          <div class="form-group col-md-6">
            <div class="form-group">
              <label>Teléfono </label> 
			  <form:input path="telefono" type="number" class="form-control" required="required"/>
<%--               <form:errors class="text-danger" path="telefono"></form:errors> --%>
            </div>
          </div>

          <div class="form-group col-md-6">
            <div class="form-group">
              <label>Correo Electrónico</label> 
              <form:input path="correo" type="email" class="form-control"
						maxlength="40" minlength="3" placeholder="Formato ej: email@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,63}$" required="required" />
<%-- 						<form:errors class="text-danger" path="correo"></form:errors> --%>
            </div>
          </div>

          <div class="form-group col-md-6">
            <div class="form-group">
              <label>Dirección</label> 
               <form:input path="direccion" minlength="3"  maxlength="45" type="text" class="form-control" required="required"/>
<%--                <form:errors class="text-danger" path="direccion"></form:errors> --%>
            </div>
          </div>

          <div class="form-group col-md-6">
            <div class="form-group">
              <label>País</label> 
               <input type="text" value="Inglaterra" class="form-control" required="required">
				<form:input path="paisDTO.id" value="1" type="hidden" class="form-control" required="required"/>
				<form:input path="paisDTO.pais" value="Inglaterra" type="hidden" class="form-control" required="required"/>
            </div>
          </div>
        </div>


        <button type="submit" class="btn btn-primary btn-md btn-block">Guardar Cambios</button>
      </form:form>
    </div>





  </div>
</div>


<%@ include file="/WEB-INF/jsp/shared/footer.jspf"%>
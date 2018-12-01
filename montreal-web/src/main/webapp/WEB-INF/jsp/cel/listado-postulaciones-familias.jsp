<%@page import="duoc.portafolio.montrealweb.DTO.ProgramaEstudioDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>

<div class="container">
  <div class="row">
    <div class="col-md-12 text-center">
      <h1>Listado Solicitudes Postulación Familias</h1>
      <br>
      <br>
    </div>
    <div class="col-md-12">
    </div>
    <br>
      
    <table id="table" class="table table-striped table-hover " style="margin-top: 20px">
      <thead>
        <tr>
          <th>ID Familia</th>
          <th>Representante Familia</th>
          <th>País</th>
          <th>Correo Electrónico</th>
          <th>Teléfono</th>
          <th>Estado Postulación</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="postulacion" items="${listPostulacionFamiliaCelOutDTO}" >
          <tr>
            <td>${postulacion.idFamilia} </td>
            <td>${postulacion.nombreFamilia } ${postulacion.apellidoFamilia }</td>
            <td>${postulacion.paisDTO.pais }</td>
            <td>${postulacion.correo }</td>
            <td>${postulacion.telefono}</td>
            <td>${postulacion.estadoPostulacion.nombreEstado}</td>
            <td>
            
	            <c:if test="${postulacion.estadoPostulacion.idEstadoPostulacion == 2}">
	            	<a href="/cel/actualizar-postulacion-familia-cel?id_postulacion=${postulacion.idPostulacion }&estado=1" class="btn btn-success btn-sm btn-block">Activar Postulación</a>
	            </c:if>
	            
	            <c:if test="${postulacion.estadoPostulacion.idEstadoPostulacion == 1}">
	            	
	            	<a href="/cel/actualizar-postulacion-familia-cel?id_postulacion=${postulacion.idPostulacion }&estado=2" class="btn btn-danger btn-sm btn-block">Rechazar Postulación</a>
	            </c:if>	 
	                        
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/shared/footer.jspf"  %>
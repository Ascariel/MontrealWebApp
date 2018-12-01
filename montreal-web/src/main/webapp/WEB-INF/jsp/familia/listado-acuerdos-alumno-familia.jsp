<%@page import="duoc.portafolio.montrealweb.DTO.ProgramaEstudioDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>

<div class="container">
  <div class="row">
    <div class="col-md-12 text-center">
      <h1>Solicitudes de Postulación Alumnos</h1>
      <br>
      <br>
    </div>
    <div class="col-md-12">
    </div>
    <br>
      
    <table id="table" class="table table-striped table-hover " style="margin-top: 20px">
      <thead>
        <tr>
          <th>ID Acuerdo</th>
          <th>Alumno</th>
          <th>Correo</th>
          <th>País</th>
          <th>Fecha de Nacimiento</th>
          <th>Aceptación Familia</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="postulacion" items="${listadoAcuerdos}" >
          <tr>
            <td>${postulacion.idAcuerdo }</td>
            <td>${postulacion.nombreCompletoAlumno }</td>
            <td>${postulacion.correo }</td>
            <td>${familiaDTO.paisDTO.pais }</td>
            <td>${postulacion.fechaNacimiento}</td>
<%--             <td>${postulacion.textoAceptacionAlumno()}</td> --%>
            <td>${postulacion.textoAceptacionFamilia()}</td>
            <td>
            
	            <c:if test="${postulacion.aceptacionFamilia == 0}">
	            	<a href="/familia/actualizar-aceptacion-familia?idAcuerdo=${postulacion.idAcuerdo}&aceptacion=1" class="btn btn-success btn-sm">Aceptar Postulación</a>
	            </c:if>
	            
	            <c:if test="${postulacion.aceptacionFamilia == 1}">
	            	
	            	<a href="/familia/actualizar-aceptacion-familia?idAcuerdo=${postulacion.idAcuerdo}&aceptacion=0" class="btn btn-danger btn-sm ">Rechazar Postulación</a>
	            </c:if>	            
                
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/shared/footer.jspf"  %>
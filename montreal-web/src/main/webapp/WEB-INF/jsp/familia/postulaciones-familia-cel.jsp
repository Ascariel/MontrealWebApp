<%@page import="duoc.portafolio.montrealweb.DTO.ProgramaEstudioDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>

<div class="container">
  <div class="row">
    <div class="col-md-12 text-center">
      <h1>Postulaciones a Centros Locales</h1>
      <br>
      <br>
    </div>
    <div class="col-md-12">
    </div>
    <br>
      
    <table id="table" class="table table-striped table-hover " style="margin-top: 20px">
      <thead>
        <tr>
          <th>ID</th>
          <th>Centro Local</th>
          <th>País</th>
          <th>Correo Electrónico</th>
          <th>Teléfono</th>
          <th>Dirección</th>
          <th>Estado Postulación</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="postulacion" items="${listPostulacionFamiliaCelOutDTO}" >
          <tr>
            <td>${postulacion.idCentro}</td>
            <td>${postulacion.nombre }</td>
            <td>${postulacion.paisDTO.pais }</td>
            <td>${postulacion.correo }</td>
            <td>${postulacion.telefono}</td>
            <td>${postulacion.direccion}</td>
            <td>${postulacion.estadoPostulacion.nombreEstado}</td>
            <td>
                <a href="/familia/postular-cel?id=${postulacion.idCentro }" class="btn btn-warning btn-sm ">Detalle Postulación</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/shared/footer.jspf"  %>
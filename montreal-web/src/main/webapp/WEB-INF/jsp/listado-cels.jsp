<%@page import="duoc.portafolio.montrealweb.DTO.ProgramaEstudioDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>

<div class="container">
  <div class="row">
    <div class="col-md-12 text-center">
      <h1>Listado de Centros Locales Postulables</h1>
      <br>
      <br>
    </div>
    <div class="col-md-12">
<!--       <a href="/programas_estudio/new" class="btn btn-success btn-sm float-left">Ingresar Nuevo Programa</a> -->
    </div>
    <br>
      
    <table id="table" class="table table-striped table-hover " style="margin-top: 20px">
      <thead>
        <tr>
          <th>ID</th>
          <th>Nombre</th>
          <th>Pais</th>
          <th>Correo</th>
          <th>Telefono</th>
          <th>Direccion</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="cel" items="${listadoCelDTO}" >
          <tr>
            <td>${cel.idCentro}</td>
            <td>${cel.nombre }</td>
            <td>${cel.paisDTO.nombrePais }</td>
            <td>${cel.correo }</td>
            <td>${cel.telefono}</td>
            <td>${cel.direccion}</td>
            <!-- ACCIONES SEGUN PERFIL -->
            <td>
<%--              <a href="/eliminar-programa?id=${programa.idProgramaEstudio}" class="btn btn-danger btn-sm">Eliminar</a>  --%>
<!--              <a href="/programas_estudio/1/edit" class="btn btn-warning btn-sm">Editar</a> -->
                <a href="/detalle-cel?id=${cel.idCentro }" class="btn btn-info btn-sm ">Ver Detalles</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<%@ include file="/WEB-INF/jsp/shared/footer.jspf"  %>
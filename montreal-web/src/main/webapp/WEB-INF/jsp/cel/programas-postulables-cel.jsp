<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>


<div class="container">
  <div class="row">
    <div class="col-md-12 text-center">
      <h1>${ titulo }</h1>
      <br> <br>
    </div>
    <div class="col-md-12">
      <!--       <a href="/programas_estudio/new" class="btn btn-success btn-sm float-left">Ingresar Nuevo Programa</a> -->
    </div>
    <br>

    <table id="projects_table" class="table table-striped table-hover " style="margin-top: 20px">
      <thead>
        <tr>
          <th>ID</th>
          <th>Programa</th>
          <th>País</th>
          <th>Estado</th>
          <th>Duración</th>
          <th>Cupos Mín.</th>
          <th>Cupos Máx.</th>
          <th>Cursos Incluidos</th>
          <th>Acciones</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="programa" items="${programasDTO}">
          <tr>
            <td>${programa.idPrograma}</td>
            <td>${programa.nombre }</td>
            <td>${programa.paisDTO.pais }</td>
            <td>${programa.estadoProgramaDTO.nombreEstadoPrograma }</td>
            <td>${programa.tipoProgramaDTO.nombreTipoPrograma}</td>
            <td>${programa.cantCuposMinimos}</td>
            <td>${programa.cantCuposMaximos}</td>
            <td><select class="form-control" name='pais_id'>
                <option selected>Ver Listado</option>
                <option>Biologia</option>
                <option>Historia</option>
                <option>Algebra</option>
                <option>Calculo</option>
                <option>Genetica</option>
                <option>Fisica</option>
            </select></td>
            <td>
              <a href="/cel/detalle-programa-postulable-cel?id=${programa.idPrograma }" class="btn btn-info btn-sm ">Ver Detalles</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>


<%@ include file="/WEB-INF/jsp/shared/footer.jspf"%>
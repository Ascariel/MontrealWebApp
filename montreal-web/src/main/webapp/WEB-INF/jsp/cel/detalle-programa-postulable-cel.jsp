<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>

<div class="container">


  <div class="row">
    <div class="col-md-12 text-center">
<!--     <h3>Detalles Programa de Estudio</h3> -->
    <h3> ${tituloPostulacion}</h3>


    <hr>
  </div>

  <div class="col-md-6 offset-md-3">
    <form method="POST" action="/cel/crear-postulacion-cel-programa?id=${programaDTO.idPrograma }">
    	<c:if test="${postulacionCelPrograma.getIdPostulacion() != null }">
    		<br/>
    		<button type="submit" class="btn btn-md btn-block ${postulacionCelPrograma.textoBtnEstadoPostulacion()} }" disabled> Estado Postulaci�n: ${postulacionCelPrograma.getEstadoPostulacionDTO().getNombreEstado()} </button>
    		<br/><br/>
    	</c:if>
    
      <div class="form-group">
        <label>Nombre Programa</label>
        <input type="text" class="form-control" name="programa_estudio[nombre]" value="${programaDTO.getNombre()}"  disabled required >
      </div>

      <div class="form-group">
        <label>Pa�s</label>
        <select class="form-control" name='programa_estudio[pais_id]' disabled >
            <option value=""  >${programaDTO.getPaisDTO().getPais()}</option>
        </select>
      </div>

      <div class="row">
        <div class="form-group col-md-6">
          <div class="form-group">
            <label>Cupos M�ximos</label>
            <input type="text" class="form-control" name="programa_estudio[max_cupos]" value="${programaDTO.getCantCuposMaximos()}"  required disabled >
          </div>
        </div>

        <div class="form-group col-md-6">
          <div class="form-group">
            <label>Cupos M�nimos</label>
            <input type="text" class="form-control" name="programa_estudio[min_cupos]" value="${programaDTO.getCantCuposMinimos()}"  required disabled >
          </div>
        </div>
      </div>

      <div class="form-group">
        <label>Cursos Disponibles</label>
        <br>

          <div class="form-check form-check-inline" disabled >
            <input type="checkbox" name="cursos[curso_id_1]" value="1" class="form-check-input" checked > Algebra<br>
          </div>

          <div class="form-check form-check-inline">
            <input type="checkbox" name="cursos[curso_id_2]" value="2" class="form-check-input" checked > Calculo<br>
          </div>

          <div class="form-check form-check-inline">
            <input type="checkbox" name="cursos[curso_id_3]" value="3" class="form-check-input" checked > Genetica<br>
          </div>

          <div class="form-check form-check-inline">
            <input type="checkbox" name="cursos[curso_id_4]" value="4" class="form-check-input"  > Estadistica<br>
          </div>

          <div class="form-check form-check-inline">
            <input type="checkbox" name="cursos[curso_id_5]" value="5" class="form-check-input" checked > Java<br>
          </div>

          <div class="form-check form-check-inline">
            <input type="checkbox" name="cursos[curso_id_6]" value="6" class="form-check-input"  > Algoritmos<br>
          </div>

          <div class="form-check form-check-inline">
            <input type="checkbox" name="cursos[curso_id_7]" value="7" class="form-check-input"  > Arte<br>
          </div>

          <div class="form-check form-check-inline">
            <input type="checkbox" name="cursos[curso_id_8]" value="8" class="form-check-input" checked > Historia<br>
          </div>

          <div class="form-check form-check-inline">
            <input type="checkbox" name="cursos[curso_id_9]" value="9" class="form-check-input" checked > Biologia<br>
          </div>

          <div class="form-check form-check-inline">
            <input type="checkbox" name="cursos[curso_id_10]" value="10" class="form-check-input"  > Quimica<br>
          </div>

          <div class="form-check form-check-inline">
            <input type="checkbox" name="cursos[curso_id_11]" value="11" class="form-check-input" checked > Fisica<br>
          </div>
      </div>
      <br>

      
		<c:if test="${postulacionMismoProgramaExiste}">
			<button type="submit" class="btn btn-primary btn-md btn-block" disabled> Postulaci�n Ya Realizada</button>
			<a href="/cel/listado-programas-postulables" class="btn btn-warning btn-md btn-block"> Volver</a>
		</c:if>

		<c:if test="${postulacionProgramaDistintoExiste}">
			<button type="submit" class="btn btn-primary btn-md btn-block" disabled> Ya has postulado a un programa distinto</button>
			<a href="/cel/listado-programas-postulables" class="btn btn-warning btn-md btn-block"> Volver</a>
		</c:if>
		
		
		<c:if test="${postulacionExiste != true}">
			<button type="submit" class="btn btn-primary btn-md btn-block">Impartir Programa</a>
		</c:if>  
    </form>
  </div>





  </div>
</div>


<%@ include file="/WEB-INF/jsp/shared/footer.jspf"  %>
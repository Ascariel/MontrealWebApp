<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/jsp/shared/header.jspf"%>
<%@ include file="/WEB-INF/jsp/shared/navbar.jspf"%>





<div class="container">


	<div class="row">
		<div class="col-md-12 text-center">
			<h3>Detalles Programa de Estudio</h3>
			<hr>
		</div>

		<div class="col-md-6 offset-md-3">
			<form method="POST" action="/">
				<input name="_method" type="hidden" value="patch" />
				<div class="form-group">
					<label>Nombre Programa</label> <input type="text"
						class="form-control" name="programa_estudio[nombre]"
						value="${programaDTO.getNombre()}" disabled required>
				</div>

				<div class="form-group">
					<label>País</label> <select class="form-control"
						name='programa_estudio[pais_id]' disabled>
						<option value="">${programaDTO.getPaisDTO().getPais()}</option>
					</select>
				</div>

				<div class="row">
					<div class="form-group col-md-6">
						<div class="form-group">
							<label>Cupos Máximos</label> <input type="text"
								class="form-control" name="programa_estudio[max_cupos]"
								value="${programaDTO.getCantCuposMaximos()}" required disabled>
						</div>
					</div>

					<div class="form-group col-md-6">
						<div class="form-group">
							<label>Cupos Mínimos</label> <input type="text"
								class="form-control" name="programa_estudio[min_cupos]"
								value="${programaDTO.getCantCuposMinimos()}" required disabled>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label>Cursos Disponibles</label> <br>

					<div class="form-check form-check-inline" disabled>
						<input type="checkbox" name="cursos[curso_id_1]" value="1"
							class="form-check-input" checked> Algebra<br>
					</div>

					<div class="form-check form-check-inline">
						<input type="checkbox" name="cursos[curso_id_2]" value="2"
							class="form-check-input" checked> Calculo<br>
					</div>

					<div class="form-check form-check-inline">
						<input type="checkbox" name="cursos[curso_id_3]" value="3"
							class="form-check-input" checked> Genetica<br>
					</div>

					<div class="form-check form-check-inline">
						<input type="checkbox" name="cursos[curso_id_4]" value="4"
							class="form-check-input"> Estadistica<br>
					</div>

					<div class="form-check form-check-inline">
						<input type="checkbox" name="cursos[curso_id_5]" value="5"
							class="form-check-input" checked> Java<br>
					</div>

					<div class="form-check form-check-inline">
						<input type="checkbox" name="cursos[curso_id_6]" value="6"
							class="form-check-input"> Algoritmos<br>
					</div>

					<div class="form-check form-check-inline">
						<input type="checkbox" name="cursos[curso_id_7]" value="7"
							class="form-check-input"> Arte<br>
					</div>

					<div class="form-check form-check-inline">
						<input type="checkbox" name="cursos[curso_id_8]" value="8"
							class="form-check-input" checked> Historia<br>
					</div>

					<div class="form-check form-check-inline">
						<input type="checkbox" name="cursos[curso_id_9]" value="9"
							class="form-check-input" checked> Biologia<br>
					</div>

					<div class="form-check form-check-inline">
						<input type="checkbox" name="cursos[curso_id_10]" value="10"
							class="form-check-input"> Quimica<br>
					</div>

					<div class="form-check form-check-inline">
						<input type="checkbox" name="cursos[curso_id_11]" value="11"
							class="form-check-input" checked> Fisica<br>
					</div>
				</div>
				<br>

				<c:if test="${ perfil.equals(\"CEL\") }">
					<a href="/cel/postular-programa?id=${programaDTO.idPrograma }"
						class="btn btn-primary btn-md btn-block">Impartir Programa</a>
				</c:if>

				<c:if test="${ perfil.equals(\"ALUMNO\") }">
					<a href="/alumno/postular-programa?id=${programaDTO.idPrograma }"
						class="btn btn-primary btn-md btn-block">Postular</a>
				</c:if>
			</form>
		</div>

	</div>

	<br></br>

	<div class="row">
		<div class="col-md-12 text-center">
<!-- 			<h3>Centro Local Asociado</h3> -->
			<hr>
				
		</div>







	</div>

</div>


<%@ include file="/WEB-INF/jsp/shared/footer.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="shared/header.jspf"%>
<%@ include file="shared/navbar.jspf"%>
<div class="row">
  <div class="col-md-12 text-center">
    <h3>Ingreso Usuario</h3>
  </div>
  
  <div class="col-md-6 offset-md-3">
    <form method="POST" action="/iniciar_sesion">
      <div class="form-group">
        <label for="exampleInputEmail1">Usuario</label> <input type="text" class="form-control" name="usuario"
          id="login_username" required>
      </div>
      <div class="form-group">
        <label for="exampleInputPassword1">Contraseña</label> <input type="password" name="clave" class="form-control"
          id="user_password" required>
      </div>
      <button type="submit" class="btn btn-primary">Ingresar</button>
    </form>
  </div>
</div>

<%@ include file="shared/footer.jspf"%>

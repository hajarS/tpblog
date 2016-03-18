<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<body>
	<h1 id="banner">Bienvenue dans mon super blog!!!</h1>
	<form class="form-horizontal" action="j_spring_security_check" method="POST">
	
		<div class="form-group">
			<label for="exampleInputEmail1" class="col-sm-2 control-label">Email</label> 
			<input type="text"
				placeholder="test@example.com" id="exampleInputEmail1" class="form-control"
				name="j_username">
		</div>
		
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Mot de passe</label> 
			<input type="password" class="form-control" id="inputPassword3"
				placeholder="Password" name="j_password" class="form-control">
		</div>
		
		<button type="submit" class="btn btn-info">Connexion</button>
		
	</form>
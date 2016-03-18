<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@
taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Articles</title>
<meta charset="utf-8">

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link href="/resources/bootstrap/css/animate.min.css" rel="stylesheet">
<script src="/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="/resources/plugins/jquery-1.11.1.min.js"></script>

<style type="text/css">

body {
	background-color: #DDD;
	padding-top: 10px;
}

[class*="col-"] {
	margin-bottom: 20px;
}

img {
	width: 100%;
}

.well {
	background-color: #CCC;
	padding: 20px;
}

a:active, a:focus {
	outline: none;
}

.inline-form input {
	display: inline-block;
	width: 100px;
}
</style>

</head>
<body>
	<div class="container">
		<nav class="navbar navbar-inverse" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Les Articles</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#">Accueil</a></li>
					<li class="dropdown"><a data-toggle="dropdown" href="#">Pâtisserie
							<b class="caret"></b>
					</a>
						<ul class="dropdown-menu">
							<li><a href="#">Tarte au citron</a></li>
							<li><a href="#">Moelleux au chocolat</a></li>
							<li><a href="#">D</a></li>
							<li class="divider"></li>
							<li><a href="#">Autres témoignages</a></li>
						</ul></li>
					<li><a href="#">Liens</a></li>
					<li><a href="#">Références</a></li>
				</ul>
				<form class="navbar-form navbar-right inline-form" role="form">
					<div class="form-group">
						<input type="search" class="input-sm form-control"
							placeholder="Recherche">
						<button type="submit" class="btn btn-primary btn-sm">
							<span class="glyphicon glyphicon-eye-open"></span> Chercher
						</button>
					</div>
				</form>
			</div>
		</nav>
		<header class="row">
			<div class="col-lg-12">
				<h1>Mon amour pour les gâteaux au chocolat</h1>
			</div>
		</header>

		<div class="row">
			<section class="col-sm-4">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h3 class="panel-title">Les gâteaux au chocolat fondant :</h3>
					</div>
					<div class="list-group">
						<div class="container">
							<div class="col-lg-offset-2 col-lg-8">
								<div class="carousel slide" data-ride="carousel">
									<div class="carousel-inner">
										<div class="item active">
											<img alt="" src="images/img47.png">
										</div>
										<div class="item">
											<img alt="" src="/resources/img/fondantchocolat.jpg">
										</div>
										<div class="item">
											<img alt="" src="images/img49.png">
										</div>
									</div>
								</div>
							</div>
						</div>
						<a href="#infos" class="list-group-item" data-toggle="modal">
							miaaaaaam <span class="badge">120</span>
						</a>
						<div class="modal fade" id="infos" role="dialog"
							aria-labelledby="modalTitre" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-hidden="true">x</button>
										<h4 id="modalTitre" class="modal-title">Recette du gâteau
											au chocolat</h4>
									</div>
									<div class="modal-body">
										<blockquote>
											Cassez les oeufs en séparant les blancs des jaunes. Battez
											fermement les blancs en neige avec une pincée de sel.
											Mélangez le beurre mou et le sucre. Ajoutez-y le chocolat
											fondu tout en continuant de mélanger puis incorporez un à un
											les jaunes d'oeufs sans cesser de remuer. Ajouter la farine
											puis les blancs d'oeufs et mélangez délicatement. Beurrez un
											moule et versez-y la préparation. Faire cuire le gâteau
											environ 20 minutes sur thermostat 5.
											<hr>
											<small class="pull-right">Miss gourmande</small>
										</blockquote>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</section>

		</div>
		<div class="row">
			<section class="col-sm-12">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">Les bienfaits du chocolat</h3>
						</div>
						<thead>
							<tr>
								<th>Lieu</th>
								<th>Menace</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Le chocolat est anti-stress</td>
								<td>Demande croissante de certaines parties de l’animal
									pour la médecine chinoise traditionnelle et fragmentation des
									habitats du fait du développement non durable d’infrastructures</td>
							</tr>
							<tr>
								<td>Île de Sumatra</td>
								<td>Production d’huile de palme et de pâtes à papiers</td>
							</tr>
							<tr>
								<td>Indonésie et Malaisie</td>
								<td>Pâte à papier, l’huile de palme et le caoutchouc</td>
							</tr>
							<tr>
								<td>États-Unis</td>
								<td>Les tigres captifs représentent un danger pour les
									tigres sauvages</td>
							</tr>
							<tr>
								<td>Europe</td>
								<td>Gros appétit pour l’huile de palme</td>
							</tr>
							<tr>
								<td>Népal</td>
								<td>Commerce illégal de produits dérivés de tigres</td>
							</tr>
						</tbody>
					</table>
				</div>
			</section>
		</div>
		<div class="row">
			<section class="col-sm-8">
				<ul class="nav nav-pills">
					<li class="active"><a href="#contact" data-toggle="tab">Contact</a></li>
					<li><a href="#informations" data-toggle="tab">Informations
							pratiques</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active fade in" id="contact">
						<form class="well" role="form">
							<h4>
								<span class="label label-default">Si vous voulez me
									laisser un message</span>
							</h4>
							<h4>Comment m'avez-vous trouvé ?</h4>
							<fieldset>
								<div class="radio">
									<label for="ami" class="radio"> <input type="radio"
										name="origine" value="ami" id="ami"> Par un ami
									</label>
								</div>
								<div class="radio">
									<label for="web" class="radio"> <input type="radio"
										name="origine" value="web" id="web"> Sur le web
									</label>
								</div>
								<div class="radio">
									<label for="hasard" class="radio"> <input type="radio"
										name="origine" value="hasard" id="hasard"> Par hasard
									</label>
								</div>
								<div class="radio">
									<label for="autre" class="radio"> <input type="radio"
										name="origine" value="autre" id="autre"> Autre...
									</label>
								</div>
								<label for="textarea">Votre message :</label>
								<textarea id="textarea" class="form-control" rows="4"></textarea>
								<p class="help-block">Vous pouvez agrandir la fenêtre</p>
								<button class="btn btn-primary" type="submit">
									<span class="glyphicon glyphicon-ok-sign"></span> Envoyer
								</button>
							</fieldset>
						</form>
					</div>
					<div class="tab-pane fade" id="informations">
						<div class="well">
							<h2>Informations pratiques</h2>
							<p>Si vous êtes intéressés par la protection des tigres et si
								vous désirez prendre part aux actions menées... blablabla...</p>
						</div>
					</div>
					<div class="tab-content">
			</section>
			<section class="col-sm-4">
				<address class="thumbnail">
					<p>Vous pouvez me contacter à cette adresse :</p>
					<strong>Tigrou Alfred</strong><br> Allée des fauves<br>
					28645 Félins-sur-Loire<br>
				</address>
			</section>
		</div>
	</div>
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script>
		$(function() {
			$('.carousel').carousel();
			$('blockquote a').tooltip();
			$('.btn-group .btn:nth-child(1)').click(
					function() {
						$('iframe').attr('src',
								'http://www.youtube.com/embed/VmnIeLmjuHA');
					})
			$('.btn-group .btn:nth-child(2)').click(
					function() {
						$('iframe').attr('src',
								'http://www.youtube.com/embed/fRAG4T-iqqY');
					})
			$('.btn-group .btn:nth-child(3)').click(
					function() {
						$('iframe').attr('src',
								'http://www.youtube.com/embed/yua4jzecCIE');
					})
		});
	</script>
</body>
</html>
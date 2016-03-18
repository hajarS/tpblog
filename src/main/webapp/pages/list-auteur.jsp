<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@
taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<jsp:include page="/template/header.jsp">
	<jsp:param value="active" name="menuAdministrateurActive" />
	<jsp:param value="Solices - Détails Administrateur" name="titreOnglet" />
</jsp:include>

<div class="container">
	<div class="row">
		<div class="col-lg-12 col-md-12 col-xs-12">
			<div class="app bg-default horizontal-layout">

				<table class="table table-striped list no-m">
					<tbody>
						<tr>
							<th>Id</th>
							<th>Nom</th>
							<th>Email</th>
							<th>Actions</th>
						</tr>

						<c:forEach items="${auteurs}" var="auteur">
							<c:url var="urlAuteurDelete"
								value="/auteur/delete.do?id=${auteur.id}" />

							<c:url var="urlAuteurUpdate"
								value="/auteur/update.do?id=${auteur.id}" />
							<tr>


								<td class="text-primary"><sec:authorize
										ifAllGranted="ROLE_ADMIN">
										<a href="${urlAuteurUpdate}">${auteur.id }</a>
									</sec:authorize></td>
								<td>${auteur.nom}</td>
								<td>${auteur.email}</td>

								<sec:authorize ifAllGranted="ROLE_ADMIN">
									<td><a href="${urlAuteurDelete}">delete</a></td>
								</sec:authorize>
							</tr>
						</c:forEach>
					</tbody>

				</table>
			</div>
		</div>
	</div>
</div>
</body>
</html>
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

						<c:forEach items="${utilisateurs}" var="utilisateur">
							<c:url var="urlUtilisateurDelete"
								value="/utilisateur/delete.do?id=${utilisateur.id}" />

							<c:url var="urlUtilisateurUpdate"
								value="/utilisateur/update.do?id=${utilisateur.id}" />
							<tr>


								<td class="text-primary"><sec:authorize
										ifAllGranted="ROLE_ADMIN">
										<a href="${urlUtilisateurUpdate}">${utilisateur.id }</a>
									</sec:authorize></td>
								<td>${utilisateur.nom}</td>
								<td>${utilisateur.email}</td>

								<sec:authorize ifAllGranted="ROLE_ADMIN">
									<td><a href="${urlUtilisateurDelete}">delete</a></td>
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
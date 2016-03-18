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
							<th>Titre</th>
							<th>Chapeau</th>
							<th>Contenu</th>
							<th>Categorie</th>
							<th>Auteur</th>
							
						</tr>

						<c:forEach items="${articles}" var="article">
							<c:url var="urlArticleDelete"
								value="/article/delete.do?id=${article.id}" />

							<c:url var="urlArticleUpdate"
								value="/article/update.do?id=${article.id}" />
							<tr>


								<td class="text-primary"><sec:authorize
										ifAllGranted="ROLE_ADMIN">
										<a href="${urlArticleUpdate}">${article.id }</a>
									</sec:authorize></td>
								<td><a href="article.html">${article.titre}</a></td>
								<td>${article.chapeau}</td>
								<td>${article.contenu}</td>
								<td>${article.categorie}</td>
								<td>${article.auteur}</td>

								<sec:authorize ifAllGranted="ROLE_ADMIN">
									<td><a href="${urlArticleDelete}">delete</a></td>
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to the CineApp</title>
<spring:url value="/resources" var="urlPublic" />
<link rel="stylesheet"
	href="${urlPublic}/bootstrap/css/bootstrap.min.css">
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-12 mt-2">
				<div class="card">
					<div class="card-header h1 text-center">Today in cinema</div>
					<div class="list-group list-group-flush">
						<div class="table-responsive">
							<table class="table table-hover">
								<thead class="thead-dark">
									<tr>
										<th scope="col">Id</th>
										<th scope="col">Title</th>
										<th scope="col">Duration</th>
										<th scope="col">Classification</th>
										<th scope="col">Genre</th>
										<th scope="col">Poster</th>
										<th scope="col">Premiere Date</th>
										<th scope="col">Status</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${movies}" var="movie">
										<tr>
											<th scope="row">${movie.id }</th>
											<td>${movie.title }</td>
											<td>${movie.duration }min.</td>
											<td>${movie.classification }</td>
											<td>${movie.genre }</td>
											<td><img src="${urlPublic}/images/${movie.img}"
												width="80" height="100"></td>
											<td><fmt:formatDate value="${movie.datePremiere }"
													pattern="dd/MM/yyyy" /></td>
											<td><c:choose>
													<c:when test="${movie.status=='Active' }">
														<span class="alert alert-success"">ACTIVE</span>
													</c:when>
													<c:otherwise>
														<span class="alert alert-danger">INACTIVE</span>
													</c:otherwise>
												</c:choose></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
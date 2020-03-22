<%-- uso del tag <spring> --%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- utilizar loops, condicional y etc.. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Detalles de la pelicula</title>
<spring:url value="/resources" var="urlPublic"></spring:url>
<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">

</head>

<body>
	<jsp:include page="includes/navbar.jsp"></jsp:include>
	<!-- Fixed navbar -->

	<div class="container theme-showcase" role="main">

		<!-- Marketing messaging -->
		<div class="container marketing">

			<div class="page-header">
				<h2>${movie.title}</h2>
			</div>
			<div class="row">
				<div class="col-sm-3">
					<p class="text-center">
						<img class="img-rounded" src="${urlPublic}/images/${movie.img}"
							alt="Generic placeholder image" width="155" height="220">
					</p>
				</div>
				<div class="col-sm-9">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">DETALLES</h3>
						</div>
						<div class="panel-body">
							<p>
								T�tulo Original : ${movie.title} <br> 
								Actores : ${movie.detail.actors}<br>
								Director:  ${movie.detail.director}<br> 
								Clasificaci�n: ${movie.classification} <br>
								Duraci�n: ${movie.duration}<br> 
								G�nero: ${movie.genre} <br> 
								Fecha Estreno: ${movie.datePremiere}
							</p>

						</div>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<span class="label label-success">${dateSearch}</span>
					</h3>
				</div>
				<div class="panel-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Hora</th>
								<th>Sala</th>
								<th>Precio</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="timetables" var="timetable">
								<tr>
									<td>${timetable.hour}</td>
									<td>${timetable.hall}</td>
									<td>$${timetable.price}</td>
								</tr>
							</c:forEach>							
						</tbody>
					</table>
				</div>
			</div>


			<div class="row">
				<div class="col-sm-7">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Trailer</h3>
						</div>
						<div class="panel-body">
							<iframe width="100%" height="315"
								src="${movie.detail.trailer}"> </iframe>
						</div>
					</div>
				</div>
				<div class="col-sm-5">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">SINOPSIS</h3>
						</div>
						<div class="panel-body">
							<p>${movie.detail.synopsis}</p>
						</div>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container -->

		<hr class="featurette-divider">

		<jsp:include page="includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>

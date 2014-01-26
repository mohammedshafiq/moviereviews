<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<link rel="stylesheet" href="/css/bootstrap/bootstrap.css">
<script type="text/javascript">
	
</script>
</head>


<body>
	<div class="mainbody" style="margin-left:5px;">
		<div><h1>Movie Reviews!</h1></div>
		<div>&nbsp;</div>
		<div>
			<table class="table table-striped"
				style="width: 550px; border: 1px solid;">
				<thead>
					<tr>
						<th>Title</th>
						<th>Description</th>
					</tr>
				</thead>
				<c:forEach items="${moviesModel.movies}" var="movie">
					<tr>
						<td><c:out value="${movie.title}" /></td>
						<td><c:out value="${movie.description}" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		
		<div style="width:1000px;margin-top:30px;">
			<form:form commandName="moviesModel" action="/movies" method="POST">
				<table class="table table-striped"
					style="width: 550px; border: 1px solid;">
					<thead>
						<tr>
							<th>Title</th>
							<th>Description</th>
							<th>Submit</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><form:input path="newMovie.title" /></td>
							<td><form:input path="newMovie.description"  /></td>
							<td><input type="submit"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
		</div>
	</div>
</body>

</html>
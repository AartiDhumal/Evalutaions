<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="" class="navbar-brand"> User
					Management Application </a>
			</div>


		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->
		<div class="container text-left">
        	<a href="<%=request.getContextPath()%>/logout" class="btn btn-success">logout</a>
        </div>
        <br>

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
                        <th>Action</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="user" items="${listCustomer}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><a href="editCustomer?id=<c:out value='${user.id}' />">Edit</a>
                            								&nbsp;&nbsp;&nbsp;&nbsp; <a
                            								href="deleteCustomer?id=<c:out value='${user.id}' />">Delete</a></td>


						</tr>

				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>
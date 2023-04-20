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
    <div class="container text-left">
            <form method="get" action = "editCustomer" >
                        <button type="submit" class="btn btn-success">edit</button>
            </form>
            </div>
            <div class="container text-left">
                    <form method="get" action = "deleteCustomer" >
                                <button type="submit" class="btn btn-success">delete</button>
                    </form>
                    </div>
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



        </br>
        </br>


		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>

			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="user" items="${productList}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.name}" /></td>
							<td><c:out value="${user.price}" /></td>
							<td><c:out value="${user.quantity}" /></td>
							<td><c:out value="${user.initialQuantity}" /></td>
                            <td><a href="editProduct?id=<c:out value='${user.id}' />">Edit</a>
                                                        								&nbsp;&nbsp;&nbsp;&nbsp; <a
                                                        								href="deleteProduct?id=<c:out value='${user.id}' />">Delete</a></td>

						</tr>

				</c:forEach>
				</tbody>
			</table>


		</div>
	</div>


               total:<c:out value='${total}' />

</body>
</html>
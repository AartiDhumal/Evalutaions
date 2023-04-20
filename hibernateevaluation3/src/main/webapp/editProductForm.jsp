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
				<a href="https://www.xadmin.net" class="navbar-brand"> User Management Application </a>
			</div>
		</nav>
	</header>

	<br>
	<br>
	<br>
	<br>
	<br>
	    <div class="container col-md-5">
              <div class="card">
                 <div class="card-body">
                 <h2 style="text-align:center; color:blue;">Register</h2><br/>
       <form method="get" action="editsaveProduct">
           <div style="text-align:center;">

          <input type ="hidden" name ="id" value="<c:out value='${todo.id}' />"><br/>
          <input type ="hidden" name ="name" value="<c:out value='${todo.name}' />"><br/>
          <input type ="hidden" name ="price" value="<c:out value='${todo.price}' />"><br/>
          <input type ="hidden" name ="quantity" value="<c:out value='${todo.quantity}' />"><br/>
          <label>Enter quantity:</label>
          <input type="text" name="initqty" value="<c:out value='${todo.initialQuantity}' />"><br/><br/>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <button type="submit" class="btn btn-success">Register</button>&nbsp;&nbsp;&nbsp;&nbsp;
          <button type="Reset" class="btn btn-success">Reset</button>
    </div>

        </form>

        </div>
              </div>
           </div>
</body>
</html>
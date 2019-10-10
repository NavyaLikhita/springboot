<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en-US">

<head>
<title>Add Flight</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<style type="text/css">
body {
	background-color: #eeeeee;
}

footer {
	position: absolute;
	bottom: 0;
	width: 100%;
}

a {
	color: #212121;
}

.brand-logo {
	margin-left: 20px;
}

.card {
	margin-top: 10vh;
}

.input-field {
	margin-top: -5px;
}
</style>
</head>

<body>
	<!-- Header -->
	<jsp:include page="Header.jsp"></jsp:include>
	<!-- Header -->

	<!-- Body -->
	<div class="container">
		<div class="row">
			<div class="card col s4 offset-s4 center">
				<form:form action="flightAdd" method="POST" modelAttribute="flight">
					<div class="row">
						<h5>Add Flight</h5>
						<br>
						<div class="input-field col s12">
							<form:input id="flight_model" type="text" class="validate"
								path="flightModel"></form:input>
							<label for="flight_model">Flight Model</label>
							<span id="flight_model_error" style="color: red"></span>
						</div>
						<div class="input-field col s12">
							<form:input id="carrier_name" type="text" class="validate"
								path="carrierName"></form:input>
							<label for="carrier_name">Carrier Name</label>
							<span id="carrier_name_error" style="color: red"></span>
						</div>
						<div class="input-field col s12">
							<form:input id="seat_capacity" type="number" class="validate"
								path="seatCapacity"></form:input>
							<label for="seat_capacity">Seat Count</label>
							<span id="seat_capacity_error" style="color: red"></span>
						</div>
						<br> <input type="submit" value="Submit"
							class="waves-effect waves-light btn-large"></input>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- Body -->

	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- Footer -->
	<script>
		
	</script>
	
	
	<script src='<c:url value = "/webjars/lib/jquery/jquery.min.js"/>'></script>
	<script
		src='<c:url value = "/webjars/lib/jquery/jquery-migrate.min.js"/>'></script>
	<script
		src='<c:url value = "/webjars/lib/bootstrap/js/bootstrap.bundle.min.js"/>'></script>
	<script src='<c:url value = "/webjars/lib/easing/easing.min.js"/>'></script>
	<script src='<c:url value = "/webjars/lib/wow/wow.min.js"/>'></script>
	<script
		src='<c:url value = "/webjars/lib/waypoints/waypoints.min.js"/>'></script>
	<script
		src='<c:url value = "/webjars/lib/counterup/counterup.min.js"/>'></script>
	<script src='<c:url value = "/webjars/lib/superfish/hoverIntent.js"/>'></script>
	<script
		src='<c:url value = "/webjars/lib/superfish/superfish.min.js"/>'></script>

	<!-- Contact Form JavaScript File -->
	<script src='<c:url value = "/webjars/contactform/contactform.js" />'></script>

	<!-- Template Main Javascript File -->
	<script src='<c:url value = "/webjars/js/main.js" />'></script>
	
	
	$(function() {
			$("#flight_model_error").hide();
			$("#carrier_name_error").hide();
			$("#seat_capacity_error").hide();

			var error_flight_model = false;
			var error_carrier_name = false;
			var error_seat_capacity = false;
			
			$("#flight_model").focusout(function() {
				check_flight_model();
			});
			
			$("#carrier_name").focusout(function() {
				check_carrier();
			});
	
	
			$("#seat_capacity").focusout(function() {
				check_seat_capacity();
			});
			
			
			function check_flight_model() {
			
	
	
</body>

</html>

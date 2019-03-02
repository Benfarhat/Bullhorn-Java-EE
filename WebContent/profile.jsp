<!DOCTYPE html>
<html lang="en">
<head>


    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>

    <title><c:out value="BullHorn messaging app" /></title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>

    <!-- Custom CSS -->
    <style>
        body {
            padding-top: 50px;
        }

        .starter-template {
            padding: 40px 15px;
            text-align: center;
        }
    </style>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<jsp:include page="WEB-INF/navigation.jsp"></jsp:include>

<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="starter-template">

	
			<c:choose>
				<c:when test="${editProfile==false}">
					<h1><img src="${userimage}" alt=<c:out value="${username}"/>/>&nbsp;&nbsp;Profile for <c:out value="${username}"/></h1>
					<h2>Email: <c:out value="${useremail}"/></h2>
					<h2>Motto: <c:out value="${usermotto}"/></h2>
					<h2>Join Date: <c:out value="${userjoindate}"/></h2>
				</c:when>
				
				<c:when test="${editProfile==true}">
			        <h1><img src="${userimage}" alt="${username}"/>&nbsp;&nbsp;Edit Profile for ${username}</h1>	
					<form action="ProfileServlet" method="post">
						<input type="hidden" name="action" value="updateprofile">
						<input type="hidden" name="userid" value="${userid}">
						<h2>Email: <input type="text" name="useremail" value="${useremail}"/></h2>
						<h2>Motto: <input type="text" name="usermotto" value="${usermotto}"/></h2>
						<h2>Join Date: <c:out value="${userjoindate}"/></h2>
						<input type="submit" value="Save Changes"/>
					</form>
				</c:when>
			</c:choose>

        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.container -->
<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>
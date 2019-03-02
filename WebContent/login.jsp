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
            <h1>Login</h1>
			
            <form class="form-signin" method="post" action="LoginServlet">
            	<small>${ message } Please Sign in</small>
            	<label for="inputEmail" class="sr-only">Email address</label>
            	<input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus/>
            	<input type="hidden" name="action" id="action" value="login"/>
            	
            	<label for="inputPassword" class="sr-only">Password</label>
            	<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required/>
            	
            	<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>
            <hr>
            <a href="adduser.jsp">Join</a>
        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.container -->
<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>
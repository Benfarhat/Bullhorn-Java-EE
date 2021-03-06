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
    <div class="alert alert-danger" style="margin-top:16px;" role="alert">
	  <h4 class="alert-heading">Sorry Java has thrown an exception</h4>
	  <p>To continue, click to the back button.</p>	  
	  <hr>
	  <h5>Details</h5>
	  <p class="mb-0">Type: ${ pageContext.exception["class"] }</p>
      <p class="mb-0">Message: ${ pageContext.exception.message }</p>
	</div>


    </div>
    <!-- /.row -->
</div>
<!-- /.container -->
<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>
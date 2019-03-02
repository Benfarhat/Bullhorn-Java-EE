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
            <h1>Bullhorn Messaging App - HomePage</h1>

            <form role="form" class="form-signin" method="post" action="PostServ" onsubmit="return validate(this)">
            	<div class="form-group">
	            	<label for="posttext" class="sr-only">Create New Post (141 char):</label>
	            	<textarea name="posttext" id="posttext" class="form-control" rows="2" placeholder="Express yourself!" maxlength="141"></textarea>
	            	<div id="textarea_feedback"></div>
            	</div>
            	<div class="form-group">
	            	<input type="submit" value="Submit" id="submit"/>
	            	<input type="reset" value="Clear"/>
            	</div>
            </form>
        </div>
    </div>
    <!-- /.row -->
</div>
<!-- /.container -->
<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<script>
$(document).ready(function() {
	var text_max = 141;
	var ta = $('#textarea_feedback');
	var pt = $('#posttext');
	

	var text_length = pt.val().length;
	var text_remaining = text_max - text_length;
	
	ta.html(text_remaining + " characters remaining");
	

	pt.keyup(function(){
		var text_length = pt.val().length;
		var text_remaining = text_max - text_length;
		
		ta.html(text_remaining + " characters remaining");
	});
});

function validate(form){
	valid = true;
	if($('#posttext').val().length == 0 ){
		alert("You may not submit an empty post.");
		valid = false;
	}
	return valid;
}
</script>
</body>
</html>
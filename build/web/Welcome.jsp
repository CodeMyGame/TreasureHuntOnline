<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="theme-color" content="#269abc">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Login</title>
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-1.12.1.js" type="text/javascript"></script>
    <style>
        body{
            background-color: #269abc;
        }
        @font-face{
                 font-family: myfont;
                 src: url("fonts/contact.ttf");
            }
    </style>
    <script>
        $(document).ready(function(){
           $('#login').click(function(e){
               var email = $('#email').val().trim();
               var pass = $('#pass').val().trim();
               if(email!==''&&pass!==''){
  
                    var data = {'email':email,'password':pass};
                    $.ajax({
                       url:'Login',
                       type: 'POST',
                       data:{d:JSON.stringify(data)},
                       dataType: 'JSON',
                        success: function (data, textStatus, jqXHR) {
                            var respdata = jqXHR.responseText; 
                            var jsondata = $.parseJSON(respdata);
                            if(jsondata.success===1){
                                $('#response').fadeIn(1000);
                                $('#alert').html("SUCCESS : Login successfull");
                                $('#response').fadeOut(4000);
                                 window.location.replace("Treasure.jsp");
                            }else{
                                $('#response').fadeIn(1000);
                                $('#alert').html("FAILED : Email/Password combination mismatched!!!");
                                $('#response').fadeOut(4000);
                            }
                        },
                        error: function (jqXHR, textStatus, errorThrown) {
                            alert("Technical Server Problem!!!");
                        },
                        beforeSend: function (xhr) {

                        },
                        complete: function (jqXHR, textStatus ) {

                        }
                    
                    });
               }else{
                     $('#response').fadeIn(1000);
                     $('#alert').html("Email/Password field are empty!!!");
                     $('#response').fadeOut(4000);
               }
           }) ;
        });
    </script>
</head>

<body>
 <%
           
           if(session.getAttribute("email")!=null){
                       String site = new String("Treasure.jsp"); 
                       response.setStatus(response.SC_MOVED_TEMPORARILY);   
                       response.setHeader("Location", site);
           }
        %>
    <div class="container">
        <div class="row">
             <center><h1 style="font-family: myfont;font-size: 50px">Treasure Hunt Login</h1></center>
            <div style="margin-top: 5%" class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <center><h3 class="panel-title"><b>Please Sign In</b></h3></center>
                    </div>
                    <div class="panel-body">
                        <form role="form">
                            <fieldset>
                                <div class="form-group">
                                    <input id="email" class="form-control" placeholder="E-mail" name="email" type="email" required>
                                </div>
                                <div class="form-group">
                                    <input id="pass" class="form-control" placeholder="Password" name="password" type="password">
                                </div>
                                <div class="checkbox">
                                    <label>
                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                    </label>
                                </div>
                                <!-- Change this to a button or input when using this as a form -->
                                <input id="login" type="button" class="btn btn-lg btn-success btn-block" value="Login">
                                
                            </fieldset>
                        </form>
                       
                    </div>
                     <div class="alert alert-info alert-dismissible col-lg-12 col-xs-12 col-md-12" style="display: none" id="response" role="alert" ><center id="alert">mnvmn</center></div>         
                </div>
            </div>
        </div>
    </div>

</body>

</html>

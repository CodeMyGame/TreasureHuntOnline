<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TresureHunt</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="theme-color" content="#355F6F">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="js/angular.js" type="text/javascript"></script>
        <script src="js/jquery-1.12.1.js" type="text/javascript"></script>
       
        <style>
            @font-face{
                 font-family: myfont;
                 src: url("fonts/contact.ttf");
            }
            body{
                margin: 0;
                background-color: #355F6F;
                color: white;
            }
            .timer{
                //background-color: #23527c;
                font-size: 7vw;
            }
            .modal-header {
                background-color: #495E73;
            }
            .modal-body {
                background-color: #6253B3;
            }
        </style>
            <script>
  angular.module('timer', [])
    .controller('timercontroller', ['$scope', '$interval',
      function($scope, $interval) {
        $scope.format = 'h:mm:ss';
      }])
    // Register the 'myCurrentTime' directive factory method.
    // We inject $interval and dateFilter service since the factory method is DI.
    .directive('myCurrentTime', ['$interval', 'dateFilter',
      function($interval, dateFilter) {
        // return the directive link function. (compile function not needed)
        return function(scope, element, attrs) {
          var format,  // date format
              stopTime; // so that we can cancel the time updates

          // used to update the UI
          function updateTime() {
            element.text(dateFilter(new Date(), format));
          }

          // watch the expression, and update the UI on change.
          scope.$watch(attrs.myCurrentTime, function(value) {
            format = value;
            updateTime();
          });

          stopTime = $interval(updateTime, 1000);

          // listen on DOM destroy (removal) event, and cancel the next UI update
          // to prevent updating time after the DOM element was removed.
          element.on('$destroy', function() {
            $interval.cancel(stopTime);
          });
        };
      }]);
</script>
<script>
    $(document).ready(function(e){
       $('body').fadeIn(2000);
       $('#leaderboard').fadeIn(6000);
       //$('#leaderboard').show("slide",{direction:"right"},2050);
       $('#go').click(function(){
           var ans = $('#answer').val().trim().toLowerCase();
           var ansid = $('#current').val();
           if(ans!==''){
               var data = {'answer':ans,'answerid':ansid};
                        
         $.ajax({
                url:'Answer',
                data:{d:JSON.stringify(data)},
                dataType: 'JSON',
                success: function (data, textStatus, jqXHR) {
                        var resp = jqXHR.responseText;
                        var jsondata = $.parseJSON(resp);
                        var status = jsondata.status;
                        var nextans = parseInt(ansid)+1;
                        if(status===1){
                            $('#answer').val("");
                            $('#response').fadeIn(1000);
                            $('#alert').html("Answer is correct!!!");
                            $('#currentspan').html(nextans);
                            $('#response').fadeOut(4000);
                            $('#tresureimg').hide("slide",{direction:"left"},1000);
                            $('#tresureimg').attr("src","TreasureHunts/NITUK/TechnicalMeet/kapil.nituk@gmail.com/"+nextans+".jpg");
                            $('#tresureimg').show("slide",{direction:"right"},1000);
                            $('#current').val(parseInt(ansid)+1);
                        }
                        else{
                            $('#response').fadeIn(1000);
                            $('#alert').html("Answer is Wrong!!!");
                            $('#response').fadeOut(4000);
                        }
                        
                    },
                error: function (jqXHR, textStatus, errorThrown) {
                            $('#response').fadeIn(1000);
                            $('#alert').html("Technical server problem!!!");
                            $('#response').fadeOut(4000); 
                    },
                beforeSend: function (xhr) {
                             $('#go').attr("disabled",true);
                    },
                complete: function (jqXHR, textStatus ) {
                            $('#go').attr("disabled",false);
                }    
         });
       }else{
               $('#response').fadeIn(1000);
               $('#alert').html("Answer field is empty!!!");
               $('#response').fadeOut(4000);
       }
       }) ;
       $('#logout').click(function(e){
          $.ajax({
              url:'Logout',
              success: function (data, textStatus, jqXHR) {
                       var resp = jqXHR.responseText;
                       alert(resp);
                       window.location.replace("Welcome.jsp");
                    },
              error: function (jqXHR, textStatus, errorThrown) {
                            $('#response').fadeIn(1000);
                            $('#alert').html("Technical server problem!!!");
                            $('#response').fadeOut(4000);
                    },
              beforeSend: function (xhr) {
                        
                    },
              complete: function (jqXHR, textStatus ) {
                        
                }      
                    
          }) ;
       });
    });
</script>
    </head>
    <body style="display: none">
        <%
           String currquest =null;
           if(session.getAttribute("email")==null){
                       String site = new String("Welcome.jsp"); 
                       response.setStatus(response.SC_MOVED_TEMPORARILY);   
                       response.setHeader("Location", site);
           }else{
                       currquest =null;
                       currquest = session.getAttribute("currentquestion").toString();
           }  
        %>
    <div class="col-lg-3">
       
        </div>
         <div class="col-lg-6">
             <input style="display: none" id="current" value="<%=currquest%>">
             <center><h1 style="font-family: myfont;font-size: 50px">Treasure Hunt</h1>Question no. = <span id="currentspan"><%=currquest%></span></center>
              <input id="logout" class="col-lg-12 col-md-12 col-xs-12 btn btn-danger" type="button" value="Logout">
        <img id="tresureimg" class="img-responsive" src="TreasureHunts/NITUK/TechnicalMeet/kapil.nituk@gmail.com/<%=currquest%>.jpg" alt=""/>   
       
        <br>
        <input  id="answer" class="col-lg-12 col-md-12 col-xs-12 form-control" type="text" placeholder="Your Answer">
        <br>
        <br>
        <input id="go" class="col-lg-12 col-md-12 col-xs-12 btn btn-info" type="button" value="Submit">
        <br>
        <br>
       
        <div class="col-lg-12 col-md-12 col-xs-12" ng-app="timer" ng-controller="timercontroller">
            <center><span class="timer" my-current-time="format"></span></center>
        </div>
        
        </div>
        <div class="col-lg-3">
        </div>
        <div id="leaderboard" title="Leader board" data-toggle="modal" data-target="#myModal" style="display: none;position: fixed; box-shadow: 0px 3px 7px 0px rgba(203, 203, 203, 0.72); line-height: 70px;text-align: center; bottom:20px;right: 20px;width: 70px;height:70px;background-color:#ec971f;cursor: pointer;border-radius: 50%"><img src="images/leader.png" width="40px" height="auto" alt=""/></div>
       
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <center><h4 class="modal-title" id="myModalLabel">Leader Board</h4></center>
                                        </div>
                                        <div class="modal-body">
                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                        </div>
                                       
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <div class="alert alert-info alert-dismissible " style="display: none;position: fixed;top: 5%;right:2%" id="response" role="alert" ><center id="alert"></center></div>         
        <script src="js/jquery-ui.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script>
            
           
        </script>
    </body>
</html>

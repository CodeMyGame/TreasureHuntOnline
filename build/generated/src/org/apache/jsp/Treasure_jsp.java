package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Treasure_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("<!--\n");
      out.write("To change this license header, choose License Headers in Project Properties.\n");
      out.write("To change this template file, choose Tools | Templates\n");
      out.write("and open the template in the editor.\n");
      out.write("-->\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>TresureHunt</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"theme-color\" content=\"#355F6F\">\n");
      out.write("        <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"js/angular.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"js/jquery-1.12.1.js\" type=\"text/javascript\"></script>\n");
      out.write("       \n");
      out.write("        <style>\n");
      out.write("            @font-face{\n");
      out.write("                 font-family: myfont;\n");
      out.write("                 src: url(\"fonts/contact.ttf\");\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                margin: 0;\n");
      out.write("                background-color: #355F6F;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            .timer{\n");
      out.write("                //background-color: #23527c;\n");
      out.write("                font-size: 7vw;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("            <script>\n");
      out.write("  angular.module('timer', [])\n");
      out.write("    .controller('timercontroller', ['$scope', '$interval',\n");
      out.write("      function($scope, $interval) {\n");
      out.write("        $scope.format = 'h:mm:ss';\n");
      out.write("      }])\n");
      out.write("    // Register the 'myCurrentTime' directive factory method.\n");
      out.write("    // We inject $interval and dateFilter service since the factory method is DI.\n");
      out.write("    .directive('myCurrentTime', ['$interval', 'dateFilter',\n");
      out.write("      function($interval, dateFilter) {\n");
      out.write("        // return the directive link function. (compile function not needed)\n");
      out.write("        return function(scope, element, attrs) {\n");
      out.write("          var format,  // date format\n");
      out.write("              stopTime; // so that we can cancel the time updates\n");
      out.write("\n");
      out.write("          // used to update the UI\n");
      out.write("          function updateTime() {\n");
      out.write("            element.text(dateFilter(new Date(), format));\n");
      out.write("          }\n");
      out.write("\n");
      out.write("          // watch the expression, and update the UI on change.\n");
      out.write("          scope.$watch(attrs.myCurrentTime, function(value) {\n");
      out.write("            format = value;\n");
      out.write("            updateTime();\n");
      out.write("          });\n");
      out.write("\n");
      out.write("          stopTime = $interval(updateTime, 1000);\n");
      out.write("\n");
      out.write("          // listen on DOM destroy (removal) event, and cancel the next UI update\n");
      out.write("          // to prevent updating time after the DOM element was removed.\n");
      out.write("          element.on('$destroy', function() {\n");
      out.write("            $interval.cancel(stopTime);\n");
      out.write("          });\n");
      out.write("        };\n");
      out.write("      }]);\n");
      out.write("</script>\n");
      out.write("<script>\n");
      out.write("    $(document).ready(function(e){\n");
      out.write("       $('#go').click(function(){\n");
      out.write("           var ans = $('#answer').val().trim().toLowerCase();\n");
      out.write("           var ansid = $('#current').val();\n");
      out.write("           if(ans!==''){\n");
      out.write("               var data = {'answer':ans,'answerid':ansid};\n");
      out.write("                        \n");
      out.write("         $.ajax({\n");
      out.write("                url:'Answer',\n");
      out.write("                data:{d:JSON.stringify(data)},\n");
      out.write("                dataType: 'JSON',\n");
      out.write("                success: function (data, textStatus, jqXHR) {\n");
      out.write("                        var resp = jqXHR.responseText;\n");
      out.write("                        var jsondata = $.parseJSON(resp);\n");
      out.write("                        var status = jsondata.status;\n");
      out.write("                        var nextans = parseInt(ansid)+1;\n");
      out.write("                        if(status===1){\n");
      out.write("                            $('#response').fadeIn(1000);\n");
      out.write("                            $('#alert').html(\"Answer is correct!!!\");\n");
      out.write("                            $('#response').fadeOut(4000);\n");
      out.write("                            $('#treasureimg').hide(\"slide\",{direction:\"left\"},1000);\n");
      out.write("                            $('#tresureimg').attr(\"src\",\"TreasureHunts/NITUK/TechnicalMeet/kapil.nituk@gmail.com/\"+nextans+\".jpg\");\n");
      out.write("                            $('#treasureimg').show(\"slide\",{direction:\"right\"},1000);\n");
      out.write("                            $('#current').val(ansid+1);\n");
      out.write("                        }\n");
      out.write("                        else{\n");
      out.write("                            $('#response').fadeIn(1000);\n");
      out.write("                            $('#alert').html(\"Answer is Wrong!!!\");\n");
      out.write("                            $('#response').fadeOut(4000);\n");
      out.write("                        }\n");
      out.write("                        \n");
      out.write("                    },\n");
      out.write("                error: function (jqXHR, textStatus, errorThrown) {\n");
      out.write("                            $('#response').fadeIn(1000);\n");
      out.write("                            $('#alert').html(\"Technical server problem!!!\");\n");
      out.write("                            $('#response').fadeOut(4000); \n");
      out.write("                    },\n");
      out.write("                beforeSend: function (xhr) {\n");
      out.write("                        \n");
      out.write("                    },\n");
      out.write("                complete: function (jqXHR, textStatus ) {\n");
      out.write("                        \n");
      out.write("                }    \n");
      out.write("         });\n");
      out.write("       }else{\n");
      out.write("               $('#response').fadeIn(1000);\n");
      out.write("               $('#alert').html(\"Answer field is empty!!!\");\n");
      out.write("               $('#response').fadeOut(4000);\n");
      out.write("       }\n");
      out.write("       }) ;\n");
      out.write("       $('#logout').click(function(e){\n");
      out.write("          $.ajax({\n");
      out.write("              url:'Logout',\n");
      out.write("              success: function (data, textStatus, jqXHR) {\n");
      out.write("                       var resp = jqXHR.responseText;\n");
      out.write("                       alert(resp);\n");
      out.write("                       window.location.replace(\"Welcome.jsp\");\n");
      out.write("                    },\n");
      out.write("              error: function (jqXHR, textStatus, errorThrown) {\n");
      out.write("                            $('#response').fadeIn(1000);\n");
      out.write("                            $('#alert').html(\"Technical server problem!!!\");\n");
      out.write("                            $('#response').fadeOut(4000);\n");
      out.write("                    },\n");
      out.write("              beforeSend: function (xhr) {\n");
      out.write("                        \n");
      out.write("                    },\n");
      out.write("              complete: function (jqXHR, textStatus ) {\n");
      out.write("                        \n");
      out.write("                }      \n");
      out.write("                    \n");
      out.write("          }) ;\n");
      out.write("       });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

           String currquest =null;
           if(session.getAttribute("email")==null){
                       String site = new String("Welcome.jsp"); 
                       response.setStatus(response.SC_MOVED_TEMPORARILY);   
                       response.setHeader("Location", site);
           }else{
                       currquest = session.getAttribute("currentquestion").toString();
           }  
        
      out.write("\n");
      out.write("    <div class=\"col-lg-4\">\n");
      out.write("       \n");
      out.write("        </div>\n");
      out.write("         <div class=\"col-lg-4\">\n");
      out.write("             <input style=\"display: none\" id=\"current\" value=\"");
      out.print(currquest);
      out.write("\">\n");
      out.write("             <center><h1 style=\"font-family: myfont;font-size: 50px\">Treasure Hunt</h1>Question no. = ");
      out.print(currquest);
      out.write("</center>\n");
      out.write("              <input id=\"logout\" class=\"col-lg-12 col-md-12 col-xs-12 btn btn-danger\" type=\"button\" value=\"Logout\">\n");
      out.write("        <img id=\"tresureimg\" class=\"img-responsive\" src=\"TreasureHunts/NITUK/TechnicalMeet/kapil.nituk@gmail.com/");
      out.print(currquest);
      out.write(".jpg\" alt=\"\"/>   \n");
      out.write("       \n");
      out.write("        <br>\n");
      out.write("        <input  id=\"answer\" class=\"col-lg-12 col-md-12 col-xs-12 form-control\" type=\"text\" placeholder=\"Your Answer\">\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        <input id=\"go\" class=\"col-lg-12 col-md-12 col-xs-12 btn btn-info\" type=\"button\" value=\"Submit\">\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("       \n");
      out.write("        <div class=\"col-lg-12 col-md-12 col-xs-12\" ng-app=\"timer\" ng-controller=\"timercontroller\">\n");
      out.write("            <center><span class=\"timer\" my-current-time=\"format\"></span></center>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"alert alert-info alert-dismissible col-lg-12 col-xs-12 col-md-12\" style=\"display: none\" id=\"response\" role=\"alert\" ><center id=\"alert\">mnvmn</center></div>         \n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-lg-4\">\n");
      out.write("        </div>\n");
      out.write("        <div id=\"leaderboard\" title=\"Leader board\" style=\"position: fixed; box-shadow: 0px 3px 7px 0px rgba(203, 203, 203, 0.72); line-height: 70px;text-align: center; bottom:20px;right: 20px;width: 70px;height:70px;background-color:#ec971f;cursor: pointer;border-radius: 50%\"><img src=\"images/leader.png\" width=\"40px\" height=\"auto\" alt=\"\"/></div>\n");
      out.write("        <div id=\"navforleader\" style=\"position: fixed;display:none; width: 70%;height: 100%;background: #269abc;top:0;z-index: 1000;opacity: .9\">\n");
      out.write("            <img id=\"close\" src=\"images/close.png\" alt=\"\" width=\"50px\" height=\"auto\" style=\"float: right;cursor: pointer\"/>\n");
      out.write("            <center><h1 style=\"font-family: myfont;font-size: 4vw\">Leader board</h1></center>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <script src=\"js/jquery-ui.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script>\n");
      out.write("            var slide = \"right\";\n");
      out.write("            $('#leaderboard').click(function(e){\n");
      out.write("                $('#navforleader').toggle(\"slide\");\n");
      out.write("                \n");
      out.write("            });\n");
      out.write("            $('#close').click(function(e){\n");
      out.write("                $('#navforleader').hide(\"slide\",{direction:\"left\"},1000);\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

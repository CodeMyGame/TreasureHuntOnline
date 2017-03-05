package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    <meta name=\"theme-color\" content=\"#269abc\">\n");
      out.write("    <meta name=\"description\" content=\"\">\n");
      out.write("    <meta name=\"author\" content=\"\">\n");
      out.write("    <title>Login</title>\n");
      out.write("    <link href=\"css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("    <script src=\"js/jquery-1.12.1.js\" type=\"text/javascript\"></script>\n");
      out.write("    <style>\n");
      out.write("        body{\n");
      out.write("            background-color: #269abc;\n");
      out.write("        }\n");
      out.write("        @font-face{\n");
      out.write("                 font-family: myfont;\n");
      out.write("                 src: url(\"fonts/contact.ttf\");\n");
      out.write("            }\n");
      out.write("    </style>\n");
      out.write("    <script>\n");
      out.write("        $(document).ready(function(){\n");
      out.write("           $('#login').click(function(e){\n");
      out.write("               var email = $('#email').val().trim();\n");
      out.write("               var pass = $('#pass').val().trim();\n");
      out.write("               if(email!==''&&pass!==''){\n");
      out.write("  \n");
      out.write("                    var data = {'email':email,'password':pass};\n");
      out.write("                    $.ajax({\n");
      out.write("                       url:'Login',\n");
      out.write("                       type: 'POST',\n");
      out.write("                       data:{d:JSON.stringify(data)},\n");
      out.write("                       dataType: 'JSON',\n");
      out.write("                        success: function (data, textStatus, jqXHR) {\n");
      out.write("                            var respdata = jqXHR.responseText; \n");
      out.write("                            var jsondata = $.parseJSON(respdata);\n");
      out.write("                            if(jsondata.success===1){\n");
      out.write("                                $('#response').fadeIn(1000);\n");
      out.write("                                $('#alert').html(\"SUCCESS : Login successfull\");\n");
      out.write("                                $('#response').fadeOut(4000);\n");
      out.write("                                 window.location.replace(\"Treasure.jsp\");\n");
      out.write("                            }else{\n");
      out.write("                                $('#response').fadeIn(1000);\n");
      out.write("                                $('#alert').html(\"FAILED : Email/Password combination mismatched!!!\");\n");
      out.write("                                $('#response').fadeOut(4000);\n");
      out.write("                            }\n");
      out.write("                        },\n");
      out.write("                        error: function (jqXHR, textStatus, errorThrown) {\n");
      out.write("                            alert(\"Technical Server Problem!!!\");\n");
      out.write("                        },\n");
      out.write("                        beforeSend: function (xhr) {\n");
      out.write("\n");
      out.write("                        },\n");
      out.write("                        complete: function (jqXHR, textStatus ) {\n");
      out.write("\n");
      out.write("                        }\n");
      out.write("                    \n");
      out.write("                    });\n");
      out.write("               }else{\n");
      out.write("                     $('#response').fadeIn(1000);\n");
      out.write("                     $('#alert').html(\"Email/Password field are empty!!!\");\n");
      out.write("                     $('#response').fadeOut(4000);\n");
      out.write("               }\n");
      out.write("           }) ;\n");
      out.write("        });\n");
      out.write("    </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write(" ");

           
           if(session.getAttribute("email")!=null){
                       String site = new String("Treasure.jsp"); 
                       response.setStatus(response.SC_MOVED_TEMPORARILY);   
                       response.setHeader("Location", site);
           }
        
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("             <center><h1 style=\"font-family: myfont;font-size: 50px\">Treasure Hunt Login</h1></center>\n");
      out.write("            <div style=\"margin-top: 5%\" class=\"col-md-4 col-md-offset-4\">\n");
      out.write("                <div class=\"login-panel panel panel-default\">\n");
      out.write("                    <div class=\"panel-heading\">\n");
      out.write("                        <center><h3 class=\"panel-title\"><b>Please Sign In</b></h3></center>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"panel-body\">\n");
      out.write("                        <form role=\"form\">\n");
      out.write("                            <fieldset>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input id=\"email\" class=\"form-control\" placeholder=\"E-mail\" name=\"email\" type=\"email\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input id=\"pass\" class=\"form-control\" placeholder=\"Password\" name=\"password\" type=\"password\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"checkbox\">\n");
      out.write("                                    <label>\n");
      out.write("                                        <input name=\"remember\" type=\"checkbox\" value=\"Remember Me\">Remember Me\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Change this to a button or input when using this as a form -->\n");
      out.write("                                <input id=\"login\" type=\"button\" class=\"btn btn-lg btn-success btn-block\" value=\"Login\">\n");
      out.write("                                \n");
      out.write("                            </fieldset>\n");
      out.write("                        </form>\n");
      out.write("                       \n");
      out.write("                    </div>\n");
      out.write("                     <div class=\"alert alert-info alert-dismissible col-lg-12 col-xs-12 col-md-12\" style=\"display: none\" id=\"response\" role=\"alert\" ><center id=\"alert\">mnvmn</center></div>         \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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

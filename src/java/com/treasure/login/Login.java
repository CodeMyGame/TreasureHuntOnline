/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treasure.login;

import com.treasure.keys.Keys;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Kapil Malviya
 */
public class Login extends HttpServlet {
    
        JSONObject obj ;
        String email=null;
        String passfromUser = null;
        String passfromDB = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response){
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String get_email_id = request.getParameter("username");
            String get_password = request.getParameter("password");
            /* TODO output your page here. You may use following sample code. */
            JSONObject getdata = new JSONObject(request.getParameter("d"));
            obj = new JSONObject();
            email = getdata.getString("email");
            passfromUser = getdata.getString("password");
            Class.forName(Keys.JDBC_DRIVER);
            PreparedStatement ps;
            ResultSet rs;
            Connection con = DriverManager.getConnection(Keys.dbText,Keys.dbID,Keys.dbPass);
            ps = con.prepareStatement("select pass from ulogin where email=?");
            ps.setString(1,email);
            rs = ps.executeQuery();
            while(rs.next())
            {
                    passfromDB = rs.getString(1);
            }
            if(passfromUser.equals(passfromDB)){
                
                HttpSession session = request.getSession(true);
                session.setAttribute("email",email);
                PreparedStatement ps1;
                ResultSet rs1;
                ps1 = con.prepareStatement("select currentquestion from treasurehunts where email=?");
                ps1.setString(1,email);
                rs1 = ps1.executeQuery();
                String currentques=null;
                while(rs1.next())
                {
                     currentques = rs1.getString(1);
                }
                session.setAttribute("currentquestion",currentques);
                obj.put("success",1);
            }
            else{
                obj.put("success",8);
                
            }
            out.write(obj.toString());
            rs.close();
            con.close();
            ps.close();
//            JSONObject k = new JSONObject();
//            k.put("email", "email");
//            k.put("pass",passfromUser);
//            out.write("success");
            
          
        }   catch (Exception ex) {
               
            }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

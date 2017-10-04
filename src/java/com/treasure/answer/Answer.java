/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treasure.answer;

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
import org.json.JSONObject;

/**
 *
 * @author Kapil Malviya
 */
public class Answer extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = responsemikk.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            JSONObject obj = new JSONObject(request.getParameter("d"));
            JSONObject obj2 = new JSONObject();
            int answerid = obj.getInt("answerid");
            String answer = obj.getString("answer");
            String getanswer = null;
            Class.forName(Keys.JDBC_DRIVER);
            PreparedStatement ps;
            PreparedStatement ps1=null;
            ResultSet rs;
            Connection con = DriverManager.getConnection(Keys.dbText,Keys.dbID,Keys.dbPass);
            ps = con.prepareStatement("select answer from answers where answerid=?");
            ps.setInt(1,answerid);
            rs = ps.executeQuery();
            while(rs.next())
            {
                    getanswer = rs.getString(1);
            }
            if(getanswer.equals(answer)){
                obj2.put("status",1);
                ps1 = con.prepareStatement("update treasurehunts set currentquestion = ? where email = ?");
                ps1.setInt(1,answerid+1);
                HttpSession session = request.getSession(false);
                session.setAttribute("currentquestion",answerid+1);
                ps1.setString(2,session.getAttribute("email").toString());
                ps1.executeUpdate();
            }
            else{
                obj2.put("status",0);
            }
            rs.close();
            ps.close();
            con.close();
//            ps1.close();
           
            out.write(obj2.toString());
        } catch (Exception ex) {
            Logger.getLogger(Answer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

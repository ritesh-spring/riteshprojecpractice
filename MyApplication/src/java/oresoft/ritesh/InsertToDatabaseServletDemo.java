/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oresoft.ritesh;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ritesh Kumar
 */
public class InsertToDatabaseServletDemo extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    PreparedStatement pstmt;
    String str1=request.getParameter("regno");
    String str2=request.getParameter("nm");
    String str3=request.getParameter("br");
    String str4=request.getParameter("cg");
        try
        {
         try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/test";
            String username = "root";
            String password = "ritesh";
            int x=Integer.parseInt(str1);
            Float y=Float.parseFloat(str4);
            connection = (Connection) DriverManager.getConnection(url, username, password);
            pstmt=(PreparedStatement) connection.prepareStatement("insert in to student values(?,?,?,?)");
            pstmt.setInt(1, x);
            pstmt.setString(2,str2);
            pstmt.setString(3, str3);
            pstmt.setFloat(4, y);
            pstmt.executeUpdate();
            connection.close();
         }
         catch(Exception e)
         {e.printStackTrace();}
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertToDatabaseServletDemo</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println(str1);
            out.println("<h1>Servlet InsertToDatabaseServletDemo at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
           
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertToDatabaseServletDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertToDatabaseServletDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertToDatabaseServletDemo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertToDatabaseServletDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

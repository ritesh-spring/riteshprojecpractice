/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oresoft.ritesh;

import com.mysql.jdbc.Connection;
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
public class ConnectMySqlInServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8;");
        PrintWriter out = response.getWriter();
        Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/test";
            String username = "root";
            String password = "ritesh";
            connection = (Connection) DriverManager.getConnection(url, username, password);
            stmt=(Statement) connection.createStatement();
            rs=stmt.executeQuery("select * from student");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConnectMySqlInServlet</title>");  
            out.println("</head>");
            out.println("<font size=10 color=red>");
            out.println("<body text=red bgcolor=blue>");
            out.println("<table border=1 width=50% valign=top align=center cellpadding=6 fontcolor=red>");
            out.println("<caption align=bottom>Student Table</caption>");
            out.println("<tr align=left><font size=10 color=blue><th>Regd.No</th><th>Name</th><th>Branch</th><th>CGPA</th></font></tr>");
            while(rs.next())
            {
                int x=rs.getInt(1);
                out.println("<tr><font size=10 color=red><td>"+x+"</td>");
                String str1=rs.getString(2);
                out.println("<td>"+str1+"</td>");
                String str2=rs.getString(3);
                out.println("<td>"+str2+"</td>");
                String str3=rs.getString(4);
                out.println("<td>"+str3+"</td></font></tr>");
            }
           //out.println("<h1>Servlet ConnectMySqlInServlet at " + request.getContextPath () + "</h1>");
            out.println("</table>");
            out.println("</body>");
            out.println("</font>");
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
            Logger.getLogger(ConnectMySqlInServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectMySqlInServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ConnectMySqlInServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectMySqlInServlet.class.getName()).log(Level.SEVERE, null, ex);
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

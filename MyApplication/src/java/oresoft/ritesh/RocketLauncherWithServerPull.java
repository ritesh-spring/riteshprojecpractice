/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oresoft.ritesh;
import java.io.*;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.io.FileNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartResponse;
import com.oreilly.servlet.ServletUtils;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author Ritesh Kumar
 */
public class RocketLauncherWithServerPull extends HttpServlet {
   static final String LAUNCH = "ritesh.gif";
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        MultipartResponse multi = new MultipartResponse(response);
        //PrintWriter out = response.getWriter();
        ServletOutputStream out = response.getOutputStream();
        try {
           
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RocketLauncherWithServerPull</title>");  
            out.println("</head>");
            out.println("<body>");
            for (int i = 10; i > 0; i--) {
      multi.startResponse("text/plain");
      out.println(i + "...");
      multi.endResponse();
      try { Thread.sleep(1000); } catch (InterruptedException e) { }
    }
             multi.startResponse("image/gif");
    try {
      ServletUtils.returnFile(request.getRealPath(LAUNCH), out);
    }
    catch (FileNotFoundException e) {
      throw new ServletException("Could not find file: " + e.getMessage());
    }
        multi.finish();
             //out.println("<h1>Servlet RocketLauncherWithServerPull at " + request.getContextPath () + "</h1>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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

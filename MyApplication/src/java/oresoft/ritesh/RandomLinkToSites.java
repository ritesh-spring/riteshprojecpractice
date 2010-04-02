/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oresoft.ritesh;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

/**
 *
 * @author Ritesh Kumar
 */
public class RandomLinkToSites extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Vector sites = new Vector();
  Random random = new Random();
 public void init(ServletConfig config) throws ServletException {
    super.init(config);
    sites.addElement(" http://www.oracle.com");
    sites.addElement("http://www.ibm.com");
    sites.addElement("http://www.google.com");
    sites.addElement("http://www.yahoo.com");
     sites.addElement("http://www.cricinfo.com");
  }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
         response.setContentType("text/html;charset=UTF-8");
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RandomLinkToSites</title>");  
            out.println("</head>");
            out.println("<body>");
            response.setHeader("Refresh", "45");
    int siteIndex = Math.abs(random.nextInt()) % sites.size();
    String site = (String)sites.elementAt(siteIndex);
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
    //out.println("<h1>Servlet RandomLinkToSites at " + request.getContextPath () + "</h1>");
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

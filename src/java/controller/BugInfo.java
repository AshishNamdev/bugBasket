/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bugbasket.BugView;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BugD;

/**
 *
 * @author anamdev
 */
public class BugInfo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String status = request.getParameter("status").toLowerCase();
        HttpSession session = request.getSession(false);
        BugView bugView = new BugView();
        bugView.setBugStatus(status);
        ArrayList<BugD> bugFilter = bugView.prepareView((ArrayList<BugD>) session.getAttribute("bugdList"));
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BugBasket</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            out.println("<h1>Bug Filter by status "+status+"</h1>");
            out.println("<table border = 1 cellpadding = 1 cesslspacing = 1>");
            out.println("<tr>");
            out.println("<td>BugID</td>");
            out.println("<td>Title</td>");
            out.println("<td>BugDate</td>");
            out.println("<td>lastmodified</td>");
            out.println("<td>creator</td>");
            out.println("<td>priority</td>");
            out.println("<td>status</td>");
            out.println("<td>actionby</td>");
            out.println("</tr>");
            //out.println("</th>");
            for(BugD bug : bugFilter)
            {
                out.println("<tr>");
                //out.println("<h4>\n"+bugd.getBugID() +" \t "+ bugd.getTitle()+" \t "+bugd.getBugDate()+" \t"+bugd.getLastModified()+" \t "+bugd.getCreator()+" \t "+bugd.getPriority()+" \t"+bugd.getStatus()+" \t "+bugd.getActionBy()+"</h3>");
                out.println("<td>"+bug.getBugID()+"</td>");
                out.println("<td>"+bug.getTitle()+"</td>");
                out.println("<td>"+bug.getBugDate()+"</td>");
                String lastmodified = bug.getLastModified()==null ? "NA":bug.getLastModified().toString();
                out.println("<td>"+lastmodified+"</td>");
                out.println("<td>"+bug.getCreator()+"</td>");
                out.println("<td>"+bug.getPriority()+"</td>");
                out.println("<td>"+bug.getStatus()+"</td>");
                out.println("<td>"+bug.getActionBy()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br/>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
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

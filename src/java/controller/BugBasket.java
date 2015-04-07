/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BugD;
import model.Query;

/**
 *
 * @author anamdev
 */
public class BugBasket extends HttpServlet {

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
        String user = request.getParameter("user");
        PrintWriter out = response.getWriter();
        if (user.equals(""))
        {
            RequestDispatcher rd = request.getRequestDispatcher("index.html");
            out.println("<span id='response' color='red'>Please select any user from list</span>");
            //out.println(out);
            rd.include(request, response);
            return;
        }
        //user = "anamdev";
        Query query = new Query();
        query.setActionBy(user);
        query.getBugData();
        ArrayList<BugD> bugdList = query.getBugdList();
        //try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BugBasket</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Details for actionby "+user+"</h1>");
            out.println("<table border = 1 cellpadding = 1 cesslspacing = 1>");
            //out.println("<tablex    >");
            //out.println("<th>");
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
            for(BugD bugd : bugdList)
            {
                out.println("<tr>");
                //out.println("<h4>\n"+bugd.getBugID() +" \t "+ bugd.getTitle()+" \t "+bugd.getBugDate()+" \t"+bugd.getLastModified()+" \t "+bugd.getCreator()+" \t "+bugd.getPriority()+" \t"+bugd.getStatus()+" \t "+bugd.getActionBy()+"</h3>");
                out.println("<td>"+bugd.getBugID()+"</td>");
                out.println("<td>"+bugd.getTitle()+"</td>");
                out.println("<td>"+bugd.getBugDate()+"</td>");
                String lastmodified = bugd.getLastModified()==null ? "NA":bugd.getLastModified().toString();
                out.println("<td>"+lastmodified+"</td>");
                out.println("<td>"+bugd.getCreator()+"</td>");
                out.println("<td>"+bugd.getPriority()+"</td>");
                out.println("<td>"+bugd.getStatus()+"</td>");
                out.println("<td>"+bugd.getActionBy()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br/>");
            out.println("<a href='index.html'>select another user</a>");
            out.println("</body>");
            out.println("</html>");
        //}
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bugbasket.ExtBugD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
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
            out.println("<span id='response' style='color:red'>Please select any user from list</span>");
            //out.println(out);
            rd.include(request, response);
            return;
        }
        String bUser  = "\""+user+"\"";
        ExtBugD extractBug = new ExtBugD();
        ArrayList<BugD> bugdList = extractBug.extractBugDetails(user);
        
        HttpSession session = request.getSession();
        session.setAttribute("bugdList", bugdList);
        String bugInfoUrl = "<a href='http://10.136.4.62/bugBasket/BugInfo?status=";
        //String bugInfoUrl = "<a href='http://10.136.131.140/bugBasket/BugInfo?status=";
        String args = "title='click to get details' target='_blank'>";
        
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title> BugInfo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center>");
            if (extractBug.getTotalBug()<=0)
            {
                out.println("<h4> Hi "+bUser+" there are No pending bugs in your basket </h4>");
                out.println("<br/>");
                out.println("<a href='http://10.136.4.62/bugBasket/index.html'>select another user</a>");
                //out.println("<a href='http://10.136.131.140/bugBasket/index.html'>select another user</a>");
            }
            else
            {
                out.print("<h4> Hi "+bUser+" there are ");
                out.print("<a href='http://10.136.4.62/bugBasket/BugDBasket?user="+user+"' title='click to get details' target='_blank'>"+extractBug.getTotalBug()+"</a> bugs in your basket</h4>");
                //out.print("<a href='http://10.136.131.140/bugBasket/BugDBasket?user="+user+"' title='click to get details' target='_blank'>"+extractBug.getTotalBug()+"</a> bugs in your basket</h4>");
                out.println("<table border = 0.5 cellpadding = 5 cesslspacing = 5>");
                out.println("<tr>");
                out.println("<td>status</td>");
                out.println("<td>count</td>");
                out.println("</tr>");
                if (extractBug.getOpenBug()>0)
                {  
                    
                    out.println("<tr>");
                    out.println("<td>"+bugInfoUrl+"open'"+args+"Open</a></td>");
                    out.println("<td>"+bugInfoUrl+"open'"+args+extractBug.getOpenBug()+"</a></td>");
                    out.println("</tr>");
                }
                if (extractBug.getClosedBug()>0)
                {  
                    out.println("<tr>");
                    out.println("<td>"+bugInfoUrl+"closed'"+args+"Closed</a></td>");
                    out.println("<td>"+bugInfoUrl+"closed'"+args+extractBug.getClosedBug()+"</a></td>");
                    out.println("</tr>");
                }
                if (extractBug.getImplementedBug()>0)
                {  
                    out.println("<tr>");
                    out.println("<td>"+bugInfoUrl+"Implemented'"+args+"Implemented</a></td>");
                    out.println("<td>"+bugInfoUrl+"Implemented'"+args+extractBug.getImplementedBug()+"</a></td>");
                    out.println("</tr>");
                }
                if (extractBug.getTriagedBug()>0)
                {  
                    out.println("<tr>");
                    out.println("<td>"+bugInfoUrl+"Triaged'"+args+"Triaged</a></td>");
                    out.println("<td>"+bugInfoUrl+"Triaged'"+args+extractBug.getTriagedBug()+"</a></td>");
                    out.println("</tr>");
                }

                if (extractBug.getAnalyzedBug()>0)
                {  
                    out.println("<tr>");
                    out.println("<td>"+bugInfoUrl+"Analyzed'"+args+"Analyzed</a></td>");
                    out.println("<td>"+bugInfoUrl+"Analyzed'"+args+extractBug.getAnalyzedBug()+"</a></td>");
                    out.println("</tr>");
                }

                if (extractBug.getNeedMoreInfoQA()>0)
                {  
                    out.println("<tr>");
                    out.println("<td>"+bugInfoUrl+"Need More Info - QA'"+args+"Need More Info - QA</a></td>");
                    out.println("<td>"+bugInfoUrl+"Need More Info - QA'"+args+extractBug.getNeedMoreInfoQA()+"</a></td>");
                    out.println("</tr>");
                }
                out.println("</table>");
                out.println("<br/>");
                out.println("<a href='http://10.136.4.62/bugBasket/index.html'>select another user</a>");
                //out.println("<a href='http://10.136.131.140/bugBasket/index.html'>select another user</a>");
                out.println("</center>");
            }
            out.println("</body>");
            out.println("</html>");
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
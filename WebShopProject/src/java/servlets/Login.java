/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import prepare.IDontKnow;
import util.HibernateUtil;

/**
 *
 * @author Veljko
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        //if(email==true && password==true) uloguj, ako ne vrati na login.jsp i
        //izbaci your username or password was incorrect
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //trying
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        sesija.beginTransaction();
        //vidi oko ovih navodnika jel moze nekako da se izbegne onim setString
        //uzmi listu gde je email neki(jedan objekat), uzmi od njega id i proveri jel sifra dobra, ako jeste login
        Query byEmail = sesija.createQuery("from Customer c where c.email=?");
        byEmail.setString(0, email);
        Customer c = (Customer) byEmail.uniqueResult();
        sesija.getTransaction().commit();
        if (c != null) {
            if (c.getPassword().equals(password)) {
                response.sendRedirect("logged.jsp");
            } else {
                try (PrintWriter out = response.getWriter()) {
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Servlet Login</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<div class=\"invalidLogin\"><form action=\"Login\">\n"
                            + "            Email:<input type=\"text\" name=\"email\" value=\"\">\n"
                            + "            Password:<input type=\"password\" name=\"password\" value=\"\">\n"
                            + "            <input type=\"submit\" name=\"Login\" value=\"Login\">\n"
                            + "        </form><br><p>Invalid email or password!</p></div>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet Login</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class=\"invalidLogin\"><form action=\"Login\">\n"
                        + "            Email:<input type=\"text\" name=\"email\" value=\"\">\n"
                        + "            Password:<input type=\"password\" name=\"password\" value=\"\">\n"
                        + "            <input type=\"submit\" name=\"Login\" value=\"Login\">\n"
                        + "        </form><br><p>Invalid email or password!</p></div>");
                out.println("</body>");
                out.println("</html>");
            }
        }
        /*List<Customer> customers = byEmail.list();
        if(!customers.isEmpty()) {
            if(customers.get(0).getPassword().equals(password)) {
                response.sendRedirect("logged.jsp");
            }
            else {
            response.sendRedirect("login.jsp");
            }
        }
        else {
            response.sendRedirect("login.jsp");
        }*/

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

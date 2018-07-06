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
import org.hibernate.SessionFactory;
import util.HibernateUtil;

/**
 *
 * @author Veljko
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

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
        String firstName, lastName, phoneNumber, email, password, birthDate;
        firstName = request.getParameter("firstName");
        lastName = request.getParameter("lastName");
        phoneNumber = request.getParameter("phoneNumber");
        email = request.getParameter("email");
        password = request.getParameter("password");
        //ne moze svako da se registruje, ako mejl vec postoji u bazi mora da unese neki drugi mejl
        //mozda treba ove metoda da bacis u neku hibernate klasu gde ce biti svi upiti kao, pa da samo 
        //zoves metode
        Session sesija = HibernateUtil.getSessionFactory().openSession();
        Query byEmail = sesija.createQuery("from Customer c where c.email=?");
        byEmail.setString(0, email);
        if (!byEmail.list().isEmpty()) {
            response.sendRedirect("register.jsp");
        } else {
            Customer c = new Customer(firstName, lastName, phoneNumber, email, password);
            sesija.beginTransaction();
            sesija.save(c);
            sesija.getTransaction().commit();
            response.sendRedirect("login.jsp");
        }
        try (PrintWriter out = response.getWriter()) {
            
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

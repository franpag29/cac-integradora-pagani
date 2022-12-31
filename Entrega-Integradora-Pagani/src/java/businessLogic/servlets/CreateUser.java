/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package businessLogic.servlets;

import businessLogic.Usuario;
import businessLogic.persistencia.Persistencia;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
@WebServlet(name = "CreateUser", urlPatterns = {"/CreateUser"})
public class CreateUser extends HttpServlet {

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
        
        try {
        Persistencia base = new Persistencia();
        base.ejecutarSQL("INSERT INTO cacintegradora.usuarios (idusuario, usuario, clave, nombreyapellido) VALUES(null,'"
                + request.getParameter("inEmail") + "', '"
                + request.getParameter("inPass") + "', '"
                + request.getParameter("inNameLastname") + "');"
        );
        
        ResultSet checkUser= base.consultaSQL("SELECT * FROM cacintegradora.usuarios WHERE usuario='"
                    + request.getParameter("inEmail") + "' and clave='"
                    + request.getParameter("inPass") + "';");
        
         
            if (checkUser.next()) {
                
                    Usuario usuarioCreado = new Usuario(checkUser.getString("usuario"),
                            checkUser.getString("clave"),
                            checkUser.getString("nombreyapellido")
                    );
                    // mando el objeto como atributo a la session
                    HttpSession sesion= request.getSession();
                    sesion.setAttribute("usuario", usuarioCreado);
                    //redirecciono al jsp correspondiente
                    response.sendRedirect("JSP/userCreated.jsp");

         
            }
        } catch (SQLException ex) {
            Logger.getLogger(CreateUser.class.getName()).log(Level.SEVERE, null, ex);
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

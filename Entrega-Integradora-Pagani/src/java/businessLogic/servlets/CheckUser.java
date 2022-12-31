package businessLogic.servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import businessLogic.Usuario;
import businessLogic.persistencia.Persistencia;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author franc
 */
@WebServlet(name = "checkUser", urlPatterns = {"/checkUser"})
public class CheckUser extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            
           
            //out.println("<h1>Servlet CheckUser at " + request.getContextPath() + "</h1>");
            //out.println("<h1>Usuario" + request.getParameter("inEmail") + "</h1>");
            //out.println("<h1>Pasword " + request.getParameter("inPass") + "</h1>");

            Persistencia base = new Persistencia();
            ResultSet resultado = base.consultaSQL("SELECT * FROM cacintegradora.usuarios WHERE usuario='"
                    + request.getParameter("inEmail") + "' and clave='"
                    + request.getParameter("inPass") + "';");

            if (resultado.next()) { 
                do {
                    Usuario usuarioLogueado = new Usuario(resultado.getString("usuario"),
                            resultado.getString("clave"),
                            resultado.getString("nombreyapellido")
                    );
                    // mando el objeto como atributo a la session
                    request.getSession().setAttribute("usuario", usuarioLogueado);
                   
                    //redirecciono al jsp correspondiente
                    response.sendRedirect("userFound.jsp");

                }while (resultado.next());

            }else{
                //SI NO HAY SIGUIENTE INMEDIATAMENTE DESPUES DE REALIZAR LA QUERY ES PORQUE 
                //NO SE ENCONTRO RESJULTDO EN LA TABLA
                response.sendRedirect("JSP/userNotFound.jsp");
                
            }
            
             

        } catch (SQLException ex) {
            Logger.getLogger(CheckUser.class.getName()).log(Level.SEVERE, null, ex);
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

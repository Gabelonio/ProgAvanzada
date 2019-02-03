/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import basedatos.DBPersonajes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica.Personaje;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertarPersonaje extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        DBPersonajes conDb = new DBPersonajes();
        
        Personaje p=null;
            try {
                p= (Personaje) Class.forName("Logica."+request.getParameter("tipoPersonaje")).newInstance();
            } catch (InstantiationException ex) {
                Logger.getLogger(InsertarPersonaje.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(InsertarPersonaje.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InsertarPersonaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        try {
            
            System.out.println(p.getClass().getSimpleName());
            System.out.println(request.getParameter("altura"));
            
            try{
                p.setAltura(Double.parseDouble(request.getParameter("altura")));
                if(p.getAltura()<=0) //se da la excepcion si el peso o altura es negativo o cero
                    throw new NumberFormatException();
                }
            catch(NumberFormatException ex)
            {
                try {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Error de datos</title>");
                    out.println("</head>");
                    out.println("<body>"); 
                    out.println("<h1 align=\"center\" > Debe ingresar datos numericos validos para la altura</h1>");
                    out.println("<p align=\"center\" ><a href='SeleccionPersonaje.jsp'>regresar</a></p>");           
                    out.println("</body>");
                    out.println("</html>");
                }
                finally{
                    out.close();
                }
            }
            p.crearPersonaje(request.getParameter("color"),
                             Double.parseDouble(request.getParameter("altura")),
                             request.getParameter("nombre"));
            
            
            conDb.insertarPersonaje(p);
            
            request.getSession().setAttribute("personaje", p);
            response.sendRedirect("MenuPersonaje.jsp");
            
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import basedatos.DBPersonajes;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica.Personaje;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabelonio
 */
public class CargarPersonaje extends HttpServlet {

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
        DBPersonajes conDB = new DBPersonajes();
        String opc = request.getParameter("op");

         
        Personaje p=null;
        
       
        try {
            int conId = Integer.parseInt(request.getParameter("item"));

            ResultSet res = conDB.getPersonajeById(conId);
           
            if(res.next()){
                
                try {
                    p= (Personaje) Class.forName("Logica."+res.getString("con_clase")).newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(InsertarPersonaje.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(InsertarPersonaje.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                        Logger.getLogger(InsertarPersonaje.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(p.getClass().getSimpleName());

                p.setID(res.getInt("con_id"));
                p.crearPersonaje(res.getString("con_color"),
                                 Double.parseDouble(res.getString("con_altura")),
                                 res.getString("con_nombre"));
                
            }
            if(opc.equals("see")){
                request.getSession().setAttribute("personaje", p);
                response.sendRedirect("MenuPersonaje.jsp");
            }
            if(opc.equals("edit")){
                request.getSession().setAttribute("personaje", p);
                response.sendRedirect("EditarPersonaje.jsp");
            }
            if(opc.equals("delete")){
                conDB.borrarPersonaje(p);
                response.sendRedirect("Inicio");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {            
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

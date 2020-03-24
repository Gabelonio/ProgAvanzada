/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica.*; 
/**
 *
 * @author Estudiantes
 */
@WebServlet(urlPatterns = {"/Receptor"})
public class Receptor extends HttpServlet {

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
        Usuario usuario;
        if(request.getParameter("usuario").equals("cliente"))
            usuario=new Cliente();
        else
            usuario=new Proveedor(); 
        
        usuario.setNombres(request.getParameter("nombre"));
        usuario.setApellidos(request.getParameter("apellido"));
        usuario.setEdad(request.getParameter("edad"));
        usuario.setGenero(request.getParameter("genero"));
        usuario.setDireccion(request.getParameter("direccion"));
        usuario.setTelefono(request.getParameter("telefono"));
        usuario.setComentarios(request.getParameter("comentarios"));
        PrintWriter out = response.getWriter();
        
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Pagina de Inscripcion</title>");  
            //out.println("<link rel='icon' type='image/png' href='printer.png' />");  
            //out.println("<link href='estilodos.css' rel='stylesheet' type='text/css' />");  
            out.println("</head>");
            out.println("<body>");
            out.println("<table border=\"1\" align=\"center\" style=\"width:30%\">");
            out.println("<tr>");
            out.println("<td colspan=\"2\" align=\"center\">");
            out.println("<h1>Formulario de Empresa</h1> ");
            out.println("</td>");
            
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td width=\"20%\"><b>Nombres</b></td>");
            out.println("<td width=\"80%\"align=\"center\">"+usuario.getNombres()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><b>Apellidos</b></td>");
            out.println("<td align=\"center\">"+usuario.getApellidos()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><b>Genero</b></td>");
            out.println("<td align=\"center\">"+usuario.getGenero()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><b>Edad</b></td>");
            out.println("<td align=\"center\">"+usuario.getEdad()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><b>Telefono</b></td>");
            out.println("<td align=\"center\">"+usuario.getTelefono()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><b>Direccion</b></td>");
            out.println("<td align=\"center\">"+usuario.getDireccion()+"</td>");
            out.println("</tr>");
            
            if(usuario.getClass().getSimpleName().equals("Proveedor"))
            {
                Contacto contacto=new Contacto(); 
                contacto.setNombreContacto(request.getParameter("nombreContacto"));
                contacto.setExtensionContacto(request.getParameter("extension"));
                Proveedor p=new Proveedor();
                p.setContacto(contacto);
                
                out.println("<tr>");
                out.println("<td><b>Nombre Contacto</b></td>");
                out.println("<td align=\"center\">"+p.getContacto().getNombreContacto()+"</td>");
                out.println("</tr>");
                
                out.println("<tr>");
                out.println("<td><b>Extension Contacto</b></td>");
                out.println("<td align=\"center\">"+p.getContacto().getExtensionContacto()+"</td>");
                out.println("</tr>");
            }
            
            out.println("<tr>");
            out.println("<td align=\"left\" valign=\"top\"><b>Comentarios</b></td>");
            out.println("<td height=\"100\" align=\"left\" valign=\"top\">"+usuario.getComentarios()+"</td>");
            out.println("</tr>");
            
            out.println("</table>");
            out.println("<p align=\"center\" ><a href='formulario.jsp'>regresar</a></p>");
            out.println("</body>");
            out.println("</html>");
         
		//<link rel="icon" type="image/png" href="imagenes/printer.png" />
		//<link href="estilos/estilodos.css" rel="stylesheet" type="text/css">
		//<SCRIPT src="recursos/ExitoScript.js" type="text/javascript" languaje="JavaScript"></SCRIPT>
/*
		<tr> 
			<td colspan="2">
				<center>
					<input type="button" value ="Volver al Menu" onclick="window.location.href='Formulario.html'">
				</center>
			</td>
		</tr> 
                */
        } finally { 
            out.close();
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


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica.Animal;
import Logica.Tortuga;
import Logica.Conejo;
import Logica.Mirlo;
import Logica.Mapache; //cambio

@WebServlet(urlPatterns = {"/Adopcion"})
public class Adopcion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param animal
     * @param nombre
     */
    public void Liskov(Animal animal, String nombre)
    {
        animal.crearAnimal(nombre);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)      
            
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Animal adopcion=null; 
        String nombre=request.getParameter("nombre");
        String tipoAnimal=request.getParameter("tipoAnimal");
        String tituloCaracteristica=null;
        
        if(tipoAnimal.equals("conejo"))
        {
            Conejo conejo=new Conejo();
            Liskov(conejo,nombre);
            adopcion=conejo;
            tituloCaracteristica="Color de pelo";
        }    
        else if(tipoAnimal.equals("mirlo"))
        {
            Mirlo mirlo=new Mirlo();
            Liskov(mirlo,nombre);
            adopcion=mirlo;
            tituloCaracteristica="Color de plumas";
        }
        else if(tipoAnimal.equals("tortuga"))
        {
            Tortuga tortuga=new Tortuga();
            Liskov(tortuga,nombre);
            adopcion=tortuga;
            tituloCaracteristica="Cantidad de Extremidades";
        }
        else if(tipoAnimal.equals("mapache")) //cambio
        {
            Mapache mapache=new Mapache();
            Liskov(mapache,nombre);
            adopcion=mapache;
            tituloCaracteristica="Color de Pelo";
        }
        PrintWriter out = response.getWriter();
        
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Pagina de adopcion</title>");  
            out.println("<link href=\"estiloAdopcion.css\" rel=\"stylesheet\" type=\"text/css\">");  
            out.println("</head>");
            out.println("<body>");
            out.println("<table border=\"1\" align=\"center\">");
            out.println("<tr>");
            out.println("<td colspan=\"2\" align=\"center\">");
            out.println("<h1>Formulario de Adopcion</h1> ");
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td colspan=\"2\" align=\"center\"> <img src=\""+tipoAnimal+".jpg\" height=\"200\" width=\"350\">");
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td class=\"clase1\" width=\"30%\"><b>Nombre</b></td>");
            out.println("<td class=\"clase2\" width=\"70%\"align=\"center\">"+adopcion.getNombre()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td class=\"clase1\" ><b>Clase</b></td>");
            out.println("<td class=\"clase2\" align=\"center\">"+adopcion.getClase()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td class=\"clase1\" ><b>Orden</b></td>");
            out.println("<td class=\"clase2\" align=\"center\">"+adopcion.getOrden()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td class=\"clase1\" ><b>Especie</b></td>");
            out.println("<td class=\"clase2\" align=\"center\">"+adopcion.getEspecie()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td class=\"clase1\" ><b>"+tituloCaracteristica+"</b></td>");
            out.println("<td class=\"clase2\" align=\"center\">"+adopcion.getCaracteristica()+"</td>");
            out.println("</tr>");
            
            out.println("</table>");
            out.println("<p align=\"center\" ><a href='CentroZoonosis.jsp'>regresar</a></p>");
            out.println("</body>");
            out.println("</html>");
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

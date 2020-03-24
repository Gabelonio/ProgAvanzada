
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Logica.Personaje;
import Logica.Bowser;
import Logica.Luigi;
import Logica.Mario;
import Logica.Toad; //cambio

@WebServlet(urlPatterns = {"/MenuPersonaje"})
public class MenuPersonaje extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param personaje
     * @param color
     * @param altura
     * @param nombre
     */
    public void Liskov(Personaje personaje,String color,double altura, String nombre)
    {
        personaje.crearPersonaje(color,altura,nombre);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)      
            
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Personaje personaje=null; 
        Double altura=0.0; 
        String nombre=request.getParameter("nombre");
        String color=request.getParameter("color");
        String tipoPersonaje=request.getParameter("tipoPersonaje");
        String tituloCaracteristica=null;
        
        try{
            altura=Double.parseDouble(request.getParameter("altura"));
            if(altura<=0) //se da la excepcion si el peso o altura es negativo o cero
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
        
        if(tipoPersonaje.equals("Bowser"))
        {
            Bowser bowser=new Bowser();
            Liskov(bowser,color,altura,nombre);
            personaje=bowser;
            tituloCaracteristica="Cantidad de Extremidades";
        }    
        else if(tipoPersonaje.equals("Mario"))
        {
            Mario mario=new Mario();
            Liskov(mario,color,altura,nombre);
            personaje=mario;
            tituloCaracteristica="Color de Cabello";
        }
        else if(tipoPersonaje.equals("Luigi"))
        {
            Luigi luigi=new Luigi();
            Liskov(luigi,color,altura,nombre);
            personaje=luigi;
            tituloCaracteristica="Color de Cabello";
        }
        else if(tipoPersonaje.equals("Toad")) //cambio
        {
            Toad toad=new Toad();
            Liskov(toad,color,altura,nombre);
            personaje=toad;
            tituloCaracteristica="Color de Piel";
        }
        
        
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Menu de Personaje</title>");  
            out.println("<link href=\"estiloAdopcion.css\" rel=\"stylesheet\" type=\"text/css\">");  
            out.println("</head>");
            out.println("<body background=\"MarioFondoDos.jpg\">");
            out.println("<table border=\"1\" align=\"center\">");
            out.println("<tr>");
            out.println("<td colspan=\"2\" align=\"center\">");
            out.println("<h2>Personaje Creado</h2> ");
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td colspan=\"2\" align=\"center\"> <img src=\""+personaje.getClass().getSimpleName()+personaje.getColor()+".jpg\" height=\"350\" width=\"350\">");
            out.println("</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td class=\"clase1\" width=\"30%\"><b>Nombre</b></td>");
            out.println("<td class=\"clase2\" width=\"70%\"align=\"center\">"+personaje.getNombre()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td class=\"clase1\" ><b>Altura</b></td>");
            out.println("<td class=\"clase2\" align=\"center\">"+personaje.getAltura()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td class=\"clase1\" ><b>Color</b></td>");
            out.println("<td class=\"clase2\" align=\"center\">"+personaje.getColor()+"</td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td class=\"clase1\" ><b>"+tituloCaracteristica+"</b></td>");
            out.println("<td class=\"clase2\" align=\"center\">"+personaje.getCaracteristica()+"</td>");
            out.println("</tr>");
            
            out.println("</table>");
            out.println("<p align=\"center\" ><a href='SeleccionPersonaje.jsp'>regresar</a></p>");
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

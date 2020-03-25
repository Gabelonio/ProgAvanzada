
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import LogicaAgentes.Entrenador;
import LogicaAgentes.Cliente;
import LogicaRutinas.Rutina;
import LogicaRutinas.RutinaAdelgazamiento;
import LogicaRutinas.RutinaTonificacion;
import LogicaRutinas.RutinaSaludable; //Cambio (Abierto/Cerrado)
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/FormularioRutina"})
public class FormularioRutina extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param entrenador
     * @param rutina
     */
    
    /* Metodo de sustitución de Liskov para asignar las rutinas concretas que
     * el usuario desea
    */
    public void Liskov(Entrenador entrenador,Rutina rutina)
    {
        entrenador.asignarRutinas(rutina);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)      
            
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Entrenador entrenador=new Entrenador();
        Cliente cliente=new Cliente();
        String nombre=request.getParameter("nombre");
        String tipoRutina=request.getParameter("tipoRutina");
        int cantidadDias=Integer.parseInt(request.getParameter("cantidadDias"));
        float pesoCliente=0;
        int alturaCliente=0;
        
        /* Manejo de excepciones si los datos altura o peso fueron ingresados
         * incorrectamente
        */
        try{
            pesoCliente=Float.parseFloat(request.getParameter("peso"));
            alturaCliente=Integer.parseInt(request.getParameter("altura"));
            if(pesoCliente<=0||alturaCliente<=0) //se da la excepcion si el peso o altura es negativo o cero
                throw new NumberFormatException();
        }
        catch(NumberFormatException ex)
        {
            try {
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error de datos</title>");
                out.println("<link href=\"estiloRutina.css\" rel=\"stylesheet\" type=\"text/css\">");
                out.println("</head>");
                out.println("<body>"); 
                out.println("<h1 align=\"center\" > Debe ingresar datos numericos validos para su peso y altura</h1>");
                out.println("<p align=\"center\" ><a href='index.html'>regresar</a></p>");           
                out.println("</body>");
                out.println("</html>");
            }
            finally{
                out.close();
            }
        }
          
        /* Asignación de la rutina dependiendo de la necesidad del usuario*/
        if(tipoRutina.equals("Adelgazamiento"))
        {
            RutinaAdelgazamiento adelgazamiento=new RutinaAdelgazamiento();
            Liskov(entrenador,adelgazamiento);
        }    
        else if(tipoRutina.equals("Tonificacion"))
        {
            RutinaTonificacion tonificacion=new RutinaTonificacion();
            Liskov(entrenador,tonificacion);
        }
        else if(tipoRutina.equals("Saludable")) //Cambio (Abierto/Cerrado)
        {
            RutinaSaludable saludable=new RutinaSaludable();
            Liskov(entrenador,saludable);
        }
       
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Rutina Asignada</title>");  
            out.println("<link href=\"estiloRutina.css\" rel=\"stylesheet\" type=\"text/css\">");  
            out.println("</head>");
            out.println("<body>");
            out.println("<table border=\"1\" align=\"center\">");
            out.println("<tr>");
            out.println("<td colspan=\"9\" align=\"center\">");
            out.println("<h1>Rutinas a realizar para "+nombre+"</h1> ");
            out.println("</td>");
            out.println("</tr>");
            
            /* Manejo de excepciones debido a la instanciación usada por del
             * metodo setRutinas
            */
            try {
                cliente.setRutinas(entrenador.programarRutinas(cantidadDias,
                        pesoCliente,alturaCliente));
            } catch (InstantiationException ex) {
                Logger.getLogger(FormularioRutina.class.getName()).log(
                        Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(FormularioRutina.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
            
            /* Impresión de las rutinas asignadas al cliente*/
            /* Recorre cada día de las rutinas*/
            for(int i=0;i<cantidadDias;i++){  
                out.println("<tr>");
                out.println("<td class=\"clase1\" width=\"20%\"><b>Dia "+
                        (i+1)+"</b></td>");
                
                /*Recorre cada ejercicio de la rutina*/
                for(int j=0;j<cliente.getEjerciciosdelDia(i).length;j++){ 
                    
                    out.println("<td class=\"clase2\" width=\"10%\""
                            + "align=\"center\">"+
                            /*Muestra la cantidad del ejercicio a realizar*/
                            cliente.getEjerciciosdelDia(i)[j].
                                    getCantidadRepeticiones()+
                            /*Discrimina si el ejercicio se realiza 
                              por minutos o por repeticiones*/
                            ((cliente.getEjerciciosdelDia(i)[j].
                                    isRepeticiones())?" repeticiones":" minutos")+ 
                            " de "+
                            /*Muestra el nombre del ejercicio a Realizar*/
                            cliente.getEjerciciosdelDia(i)[j].
                                    getNombre()+"</td>");
                }
                
                /* Acomoda la tabla dependiendo de la cantidad de ejercicios,
                 * llenando con espacios en blanco por motivos esteticos 
                 */
                for(int j=cliente.getEjerciciosdelDia(i).length;j<8;j++)
                    out.println("<td class=\"clase2\" width=\"10%\"></td>");
                
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("<p align=\"center\" ><a href='index.html'>regresar</a></p>");
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

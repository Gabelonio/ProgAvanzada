<%-- 
    Document   : editar_contacto
    Created on : 02-feb-2019
    Author     : Gabelonio
--%>

<%@page import="Logica.Personaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Contacto</title>
        <script src='validar.jsp' language='JavaScript1.2'></script>
        <link href='estiloBienvenido.css' rel='stylesheet' type='text/css'>
    </head>
    <body background="MarioFondoTres.jpg">
         <form id="frmActualizarPersonaje" action="ActualizarPersonaje" method="POST">
             <input type="hidden" id="ID" name="ID" value="<%= ((Personaje)session.getAttribute("personaje")).getID() %>">
        <table BORDER="1" align="center">
            <tr>
                <td class="clase1">Clase</td>
                <td class="clase2">
                    <center>
                        <select id="clase" name="tipoPersonaje">
                            <%if(((Personaje)session.getAttribute("personaje")).getClass().getSimpleName().equals("Bowser")){%>
                                <option selected value="Bowser">Bowser</option><% }else{%>
                                <option value="Bowser">Bowser</option><% }%>
                                
                            <%if(((Personaje)session.getAttribute("personaje")).getClass().getSimpleName().equals("Mario")){%>
                                <option selected value="Mario">Mario</option><% }else{%>                         
                                <option value="Mario">Mario</option><% }%>
                                
                            <%if(((Personaje)session.getAttribute("personaje")).getClass().getSimpleName().equals("Luigi")){%>
                                <option selected value="Luigi">Luigi</option><% }else{%>
                                <option value="Luigi">Luigi</option><% }%>
                                
                            <%if(((Personaje)session.getAttribute("personaje")).getClass().getSimpleName().equals("Toad")){%>
                                <option selected value="Toad">Toad</option><% }else{%>
                                <option value="Toad">Toad</option><% }%> <%--cambio--%>
                        </select>
                    </center>
                </td>
            </tr>
            <tr>
                <td class="clase1">Nombre</td>
                <td class="clase2"><center><input type="text" id="nombre" name="nombre" value="<%= ((Personaje)session.getAttribute("personaje")).getNombre() %>"></center></td>
            </tr>
            <tr>
                <td class="clase1">Altura</td>
                <td class="clase2"><center><input type="text" id="altura" name="altura" value="<%= ((Personaje)session.getAttribute("personaje")).getAltura() %>"></center></td>
            </tr>
            <tr>
                <td class="clase1">Color</td>
                <td class="clase2">
                    <center>
                        <select id="color" name="color">
                            <%if(((Personaje)session.getAttribute("personaje")).getColor().equals("Original")){%>
                                <option selected value="Original">Original</option><% }else{%>
                                <option value="Original">Original</option><% }%>
                                
                            <%if(((Personaje)session.getAttribute("personaje")).getColor().equals("Azul")){%>
                                <option selected value="Azul">Azul</option><% }else{%>                         
                                <option value="Azul">Azul</option><% }%>
                                
                            <%if(((Personaje)session.getAttribute("personaje")).getColor().equals("Verde")){%>
                                <option selected value="Verde">Verde</option><% }else{%>
                                <option value="Verde">Verde</option><% }%>
                                
                            <%if(((Personaje)session.getAttribute("personaje")).getColor().equals("Negro")){%>
                                <option selected value="Negro">Negro</option><% }else{%>
                                <option value="Negro">Negro</option><% }%> <%--cambio--%>
                        </select>
                    </center>
                </td>
            </tr>
            <tr>
                <td class="clase2" colspan="2" ><center><input class="boton" type="button" value="Aceptar" onclick="submit();"></center></td>
            </tr>
            
        </table>
        </form>
    </body>
</html>

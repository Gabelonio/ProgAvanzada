<%-- 
    Document   : MenuPersonaje
    Created on : 02-feb-2019, 20:14:19
    Author     : Gabelonio
--%>

<%@page import="Logica.Personaje"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% Personaje personaje = (Personaje)session.getAttribute("personaje"); %> 
<html>
    <head>
        <title>Menu de Personaje</title>
        <link href="estiloAdopcion.css" rel="stylesheet" type="text/css">
    </head>
    <body background="MarioFondo.jpg">
        <table border="1" align="center">
        <tr>
            <td colspan="2" align="center">
                <h2>Carta del Personaje</h2> 
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center"> <img src="<%=personaje.getClass().getSimpleName()+personaje.getColor()%>.jpg" height="350" width="350">
            </td>
        </tr>

        <tr>
            <td class="clase1" width="30%"><b>Nombre</b></td>
            <td class="clase2" width="70%"align="center" ><%=personaje.getNombre()%></td>
        </tr>

        <tr>
            <td class="clase1" ><b>Altura</b></td>
            <td class="clase2" align="center"><%=personaje.getAltura()%></td>
        </tr>

        <tr>
            <td class="clase1" ><b>Color</b></td>
            <td class="clase2" align="center"><%=personaje.getColor()%></td>
        </tr>

        <tr>
            <td class="clase1" >
                <b>
                    <%if(personaje.getClass().getSimpleName().equals("Bowser")){%>
                        <%="Cantidad de Extremidades"%><% }%>
                    <%if(personaje.getClass().getSimpleName().equals("Mario")||
                         personaje.getClass().getSimpleName().equals("Luigi")){%>
                        <%="Color de Cabello"%><% }%>
                    <%if(personaje.getClass().getSimpleName().equals("Toad")){%>
                        <%="Color de Piel"%><% }%>
                </b>
            </td>
            <td class="clase2" align="center"><%=personaje.getCaracteristica()%></td>
        </tr>

        </table>
            <p align="center" ><a href='Inicio'>regresar</a></p>
    </body>
</html>

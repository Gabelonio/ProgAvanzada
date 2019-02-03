<%-- 
    Document   : ListaPersonajes
    Created on : 02/02/2019
    Author     : Gabriel
--%>

<%@page import="java.util.List"%>
<%@page import="Logica.Personaje"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ResultSet personajes = (ResultSet)session.getAttribute("personajes"); %>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Personajes</title>
        <script src='validar.jsp' language='JavaScript1.2'></script>
        <link href="estiloAdopcion.css" rel="stylesheet" type="text/css">
    </head>
    <body background=MarioFondoDos.jpg>
        <h1><center>Personajes Registrados</center></h1>
        <table border=1 align=center >
            <tr>
                <th class= "clase1">CODIGO</th><th class= "clase1">CLASE</th><th class= "clase1">NOMBRE</th><th class= "clase1">ALTURA</th><th class= "clase1">COLOR</th><th class= "clase1">ACCIONES</th>
            </tr>
                <% while (personajes.next()){ %>
                    <tr>
                        <td class= "clase2"><%= personajes.getString("con_id") %></td>
                        <td><%= personajes.getString("con_clase") %></td>
                        <td><%= personajes.getString("con_nombre") %></td>
                        <td><%= personajes.getString("con_altura") %></td>
                        <td><%= personajes.getString("con_color") %></td>
                        <td class="links">
                            <a href="CargarPersonaje?op=see&item=<%= personajes.getString("con_id") %>">Ver</a>
                            <a href="CargarPersonaje?op=edit&item=<%= personajes.getString("con_id") %>">Editar</a>
                            <%-- op=edit&item asignacion de opcion editar// contactos.getString("con_id") envio de dato identificador a la pagina cargar contactos    --%>   
                            <a href="CargarPersonaje?op=delete&item=<%= personajes.getString("con_id") %>">Borrar</a>
                        </td>
                    </tr>
                <% }%>
                <tr>
                    <td colspan="6" class="links">
                        <center>
                            <a href="Inicio">Regresar</a>
                        </center>
                    </td>
            </tr>
        </table>
    </body>
</html>

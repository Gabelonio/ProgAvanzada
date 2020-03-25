<%-- 
    Document   : CentroZoonosis
    Created on : 13/09/2018, 10:53:35 AM
    Author     : Estudiantes
--%>
    
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% ResultSet personajes = (ResultSet)session.getAttribute("personajes"); %> 
<HTML>
    <HEAD>
        <TITLE>Mario Bros Personajes</TITLE>
        <link href="estiloBienvenido.css" rel="stylesheet" type="text/css">
    </HEAD>	
    <BODY background="MarioFondo.jpg">
        <FORM  action="InsertarPersonaje" method="get">
                <center>
                        <h1>Menu de seleccion de personaje Mario Bros</h1> 
                </center>
                <TABLE BORDER="1" align="center">
                        <tr>
                                <td class="clase1">
                                    <center>
                                            <h3>Seleccione el personaje que quiere crear</h3>
                                    </center>
                                </td>
                                <td colspan="2" class="clase2">
                                    <center>
                                        <select name="tipoPersonaje">
                                                <option value="Bowser">Bowser</option>
                                                <option value="Mario">Mario</option>
                                                <option value="Luigi">Luigi</option>
                                                <option value="Toad">Toad</option> <%--cambio--%>
                                        </select>
                                    </center>
                                </td>
                        </tr>
                        <tr>
                                <td class="clase1">
                                    <center>
                                        <h4>Nombre</h4>
                                    </center>
                                </td>
                                <td  class="clase2" colspan="2">
                                    <input type ="text" name="nombre" id="nombre" placeholder="Nombre" size="17" required> 
                                </td>
                        </tr>
                        <tr>
                                <td class="clase1">
                                    <center>
                                        <h4>Altura</h4>
                                    </center>
                                </td>
                                <td  class="clase2" colspan="2">
                                    <input type ="text" name="altura" id="altura" placeholder="Altura" size="17" required> 
                                </td>
                        </tr>
                        <tr>
                                <td class="clase1">
                                    <center>
                                            <h3>Seleccione el color de su personaje</h3>
                                    </center>
                                </td>
                                <td colspan="2" class="clase2">
                                    <center>
                                        <select name="color">
                                                <option value="Original">Original</option>
                                                <option value="Azul">Azul</option>
                                                <option value="Verde">Verde</option>
                                                <option value="Negro">Negro</option> 
                                        </select>
                                    </center>
                                </td>
                        </tr>
                        <tr>
                                <td colspan="2" class="clase2   " >
                                        <center>
                                            <a class="boton" href="ListaPersonajes.jsp?item=<%= personajes %>">Cargar Personajes</a>
                                        </center>
                                </td>
                                <td colspan="2" class="clase2   " >
                                        <center>
                                            <input class="boton" type="submit" value ="Registrar">
                                        </center>
                                </td>
                        </tr> 
                </TABLE>
        </FORM>
    </BODY>
</HTML> 


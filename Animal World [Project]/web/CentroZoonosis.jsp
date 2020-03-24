<%-- 
    Document   : CentroZoonosis
    Created on : 13/09/2018, 10:53:35 AM
    Author     : Estudiantes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
    <HEAD>
        <TITLE>Centro de Zoonosis</TITLE>
        <link href="estiloBienvenido.css" rel="stylesheet" type="text/css">
    </HEAD>	
    <BODY>
        <FORM  action="Adopcion" method="get">
                <center>
                        <h1>Centro de Zoonosis de Colombia</h1> 
                </center>
                <TABLE BORDER="1" align="center">
                        <tr>
                                <td class="clase1">
                                    <center>
                                            <h3>Seleccione el animal que quiere adoptar</h3>
                                    </center>
                                </td>
                                <td class="clase2">
                                    <select name="tipoAnimal">
                                            <option value="conejo">Conejo</option>
                                            <option value="mirlo">Mirlo</option>
                                            <option value="tortuga">Tortuga</option>
                                            <option value="mapache">Mapache</option> <%--cambio--%>
                                    </select>
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
                                <td colspan="3" class="clase2   " >
                                        <center>
                                                <input class="boton" type="submit" value ="Registrar">
                                        </center>
                                </td>
                        </tr> 
        </form>
    </BODY>
</HTML> 


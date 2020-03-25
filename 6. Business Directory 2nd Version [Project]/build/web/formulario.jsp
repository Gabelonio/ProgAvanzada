<%-- 
    Document   : formulario
    Created on : 5/09/2018, 09:37:05 AM
    Author     : Estudiantes
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<HTML>
    <HEAD>
        <TITLE>Directorio Empresarial</TITLE>
        <link rel="icon" type="image/png" href="form.png"/>
        <link href="estilo.css" rel="stylesheet" type="text/css">
        <script src="FormScript.js" type="text/javascript" language="JavaScript"></script>
    </HEAD>	
	<BODY>
            <FORM  name="Formulario" action="Receptor" id="formulario" method="get" onsubmit="return validar()">
                    <TABLE BORDER="1" align="center" width="460">
                            <tr>
                                    <td colspan="3">
                                            <center>
                                                    <h1>Directorio Empresarial</h1> 
                                            </center>
                                    </td>	
                            </tr>
                            <tr>
                                    <td>
                                            <center>
                                                    <h3>Usuario</h3>
                                            </center>
                                    </td>
                                    <td>
                                             <input type="radio" onclick="mostrarFormulario()" id="cliente" name="usuario" value="cliente" checked> Cliente<br>
                                             <input type="radio" onclick="mostrarFormulario()" id="proveedor" name="usuario" value="proveedor"> Proveedor<br>
                                    </td>
                                    <td>
                                            <center>
                                                    <img src="company.png">
                                            </center>
                                    </td>
                            </tr>
                    </TABLE>
                    <TABLE align="center" width="460">
                            <tr>
                                    <td>
                                            <h4>Nombres</h4>
                                    </td>
                                    <td  colspan="2">
                                        <input type ="text" name="nombre" id="nombre" placeholder="Nombres" size="17">
                                    </td>
                            </tr>
                            <tr>
                                    <td>
                                            <h4>Apellidos</h4>
                                    </td>
                                    <td colspan="2">
                                        <input type ="text" name="apellido" id="apellido" placeholder="Apellidos" size="17">
                                    </td>
                            </tr>
                            <tr>
                                    <td>
                                            <h4>Edad</h4>
                                    </td>
                                    <td colspan="2">
                                            <input type ="text"  name="edad" id="edad" placeholder="Edad" size="3">
                                    </td>
                            </tr>
                            <tr>
                                    <td>
                                            <h4>Genero</h4>
                                    </td>
                                    <td colspan="2">
                                            <input type="radio" name="genero" value="masculino" checked> Masculino<br>
                                            <input type="radio" name="genero" value="femenino"> Femenino<br>
                                    </td>
                            </tr>
                            <tr>
                                    <td>
                                            <h4>Telefono</h4>
                                    </td>
                                    <td colspan="2">
                                            <input type ="text"  name="telefono" id="telefono" placeholder="Telefono" size="8">
                                    </td>
                            </tr>
                            <tr>
                                    <td>
                                            <h4>Direccion</h4>
                                    </td>
                                    <td colspan="2">
                                            <input type = "text"  name="direccion" id="direccion" placeholder="Direccion" size="18">
                                    </td>
                            </tr>
                            <tr id="contactorow" style="visibility:hidden">
                                    <td rowspan="2">
                                            <center>
                                                    <h4>Contacto</h4>
                                            </center>
                                    </td>
                                    <td>
                                            <center>
                                            <h4>Nombre</h4>
                                            </center>
                                    </td>
                                    <td>
                                            <input type ="text" name="nombreContacto" id="nombreContacto" placeholder="Nombre" size="10">
                                    </td>
                            </tr>
                            <tr id="extensionrow" style="visibility:hidden">
                                    <td>
                                            <center>
                                                    <h4>Extension</h4>
                                            </center>
                                    </td>
                                    <td>
                                            <input type ="text" name="extension" id="extension" placeholder="Extension" size="10">
                                    </td>
                            </tr>
                            <tr>
                                    <td>
                                            <h4>Comentarios</h4>
                                    </td>
                                    <td colspan="2">
                                            <textarea name="comentarios" id="comentarios" placeholder="Comentarios" rows="8" cols="45"></textarea>
                                    </td>
                            </tr>
                            <tr>
                                    <td colspan="3">
                                            <center>
                                                    <input type="submit" value ="Registrar">
                                            </center>
                                    </td>
                            </tr> 
                    </TABLE>
            </form>
    </BODY>
</HTML> 


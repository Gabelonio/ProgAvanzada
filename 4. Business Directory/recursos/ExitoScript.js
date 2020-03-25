function leerGET()
{ 
	//obtiene la cadena de variables y valores es decir url despues del ?
	var cadGET = location.search.substr(1,location.search.length); 
	//rompe la cadena para separar pares variable=valor
	var arrGET = cadGET.split("&"); 
	var asocGET = new Array(); 
	var variable = ""; 
	var valor = ""; 
	//llena el arreglo asociativo
	for(i=0; i<arrGET.length; i++) { 
		var aux = arrGET[i].replace(/\+/g, "%20").split("=");
		variable = aux[0]; 
		valor = aux[1]; 
		asocGET[variable] = decodeURIComponent(valor);
	} 
	return asocGET; 
} 
function escribir()
{
	var paresVarValor = leerGET(); 
	document.getElementById("divUser").innerHTML=paresVarValor["usuario"];
	document.getElementById("divName").innerHTML=paresVarValor["nombre"];
	document.getElementById("divLName").innerHTML=paresVarValor["apellido"];
	document.getElementById("divAge").innerHTML=paresVarValor["edad"];
	document.getElementById("divGenero").innerHTML=paresVarValor["genero"];
	document.getElementById("divTelefono").innerHTML=paresVarValor["telefono"];
	document.getElementById("divDireccion").innerHTML=paresVarValor["direccion"];
	document.getElementById("divNameContacto").innerHTML=paresVarValor["nombreContacto"];
	document.getElementById("divExtension").innerHTML=paresVarValor["extension"];
	if(paresVarValor["comentarios"]=="")
		document.getElementById("divComentarios").innerHTML="Sin comentarios"; 
	else
		document.getElementById("divComentarios").innerHTML=paresVarValor["comentarios"];
}
function setFormulario()
{
	var paresVarValor = leerGET();
	if(paresVarValor["usuario"]=="cliente")
	{
		document.getElementById('contactorow').style.visibility = "hidden"; // or x.style.display = "none";
		document.getElementById('extensionrow').style.visibility = "hidden"; // or x.style.display = "none";
	}
	else
	{
		document.getElementById('contactorow').style.visibility = "vissible"; //or x.style.display = "block";
		document.getElementById('extensionrow').style.visibility = "vissible"; //or x.style.display = "block";
	}
}
function cargar()
{
	escribir(); 
	setFormulario();
}
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
	for(i=0;i<arrGET.length;i++){ 
		var aux = arrGET[i].split("="); 
		variable = aux[0]; 
		valor = aux[1]; 
		asocGET[variable] = valor; 
	} 
	return asocGET; 
} 
function escribir()
{
	var paresVarValor = leerGET(); 
	document.getElementById("divName").innerHTML=paresVarValor["nombre"];
	document.getElementById("divLName").innerHTML=paresVarValor["apellido"];
	document.getElementById("divAge").innerHTML=paresVarValor["edad"];
	document.getElementById("divSemester").innerHTML=paresVarValor["semestre"];
}
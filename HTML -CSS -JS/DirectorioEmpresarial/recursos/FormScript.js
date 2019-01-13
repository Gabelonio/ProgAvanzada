function mostrarFormulario()
 {
  if(document.getElementById('cliente').checked)
  {
		document.getElementById('contactorow').style.visibility = "hidden"; // or x.style.display = "none";
		document.getElementById('extensionrow').style.visibility = "hidden"; // or x.style.display = "none";
  }
  else
  {
		document.getElementById('contactorow').style.visibility = "visible"; //or x.style.display = "block";
		document.getElementById('extensionrow').style.visibility = "visible"; //or x.style.display = "block";
  }
 }
 function validar()
 {
	if(document.getElementById('nombre').value == "") 
	{
		alert('Nombre requerido');
		return false;
	}
	if(document.getElementById('apellido').value == "") 
	{
		alert('Apellido requerido');
		return false;
	}
	if(document.getElementById('edad').value == "") 
	{
		alert('Edad requerida');
		return false;
	}
	if(document.getElementById('telefono').value == "") 
	{
		alert('Telefono requerido');
		return false;
	}
	if(document.getElementById('direccion').value == "") 
	{
		alert('Direccion requerida');
		return false;
	}
	if(document.getElementById('proveedor').checked){
		if(document.getElementById('nombreContacto').value == "") {
			alert('Contacto requerido');
			return false;
		}
		if(document.getElementById('extension').value == "") {
			alert('Extension requerida');
			return false;
		}
	}	
}
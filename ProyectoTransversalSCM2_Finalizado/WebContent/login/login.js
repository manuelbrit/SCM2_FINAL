function playBg(){
var video = document.getElementById("myVideo");
video.play();
}
function login(){
	var nombre = document.getElementById("userInput").value
	var contraseña = document.getElementById("passwordInput").value
	var http = new XMLHttpRequest();
	http.onreadystatechange = function () {
		if(this.readyState == 4 && this.status == 200) {
			var rtaRecibida = this.responseText;

			if(rtaRecibida == "Existe") {
				parent.document.getElementById("container").src = "./portfolioCar/portfolio.jsp";
				sessionStorage.setItem("loginOn",true);
			}
			else {
				window.location.href="./login.jsp";	
				
			} 
		}
	};

	// Preparar la peticion por AJAX
	http.open("GET", "../AJAXCheckNombreController?comprobarNombre="+nombre+"&comprobarPassword="+contraseña, true);
	http.send();
}
function register(){
	var nombre = document.getElementById("registerUser").value.trim();
	var contraseña = document.getElementById("registerPass").value;
	var http = new XMLHttpRequest();
	http.onreadystatechange = function () {
		if(this.readyState == 4 && this.status == 200) {
			var rtaRecibida = this.responseText;	
			console.log(rtaRecibida)
		}
	};

	// Preparar la peticion por AJAX
	http.open("PUT", "../AJAXCheckNombreController?comprobarNombre="+nombre+"&comprobarPassword="+contraseña, true);
	http.send();
}
function addEvent(id) {
  var listHtml = document.getElementById(id).getElementsByTagName("input");
  for (var x = 0; x < listHtml.length; x++) {
    listHtml[x].addEventListener("focus", eventDirty);
    listHtml[x].addEventListener("focusout", eventDirty);
  }
}
function eventDirty(x) {
  var label = x.target.parentNode.getElementsByTagName("label");
  if (x.target.value.length < 1) {
    label[0].classList.toggle("active");
  }
  label[0].classList.toggle("highlight");
}
function eventDirtyRemoveHighlight(x) {
  var label = x.target.parentNode.getElementsByTagName("label");
  label[0].classList.toggle("highlight");
}

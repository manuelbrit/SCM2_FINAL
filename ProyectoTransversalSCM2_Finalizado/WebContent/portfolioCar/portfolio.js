var arrayCar = [];
function getData(){
	setTimeout(function(){var body = document.getElementById("columns");
	arrayCar.forEach(function(car){
		var figure = document.createElement("figure");
		
		var img = document.createElement("img");
		img.src = car.IMG;
		
		var figcaption = document.createElement("figcaption");
		figcaption.innerText = car.Modelo;
		
		var span = document.createElement("span");
		span.innerText = car.Precio + "€";
		span.setAttribute("class", "price");
		
		var detail = document.createElement("span");
		detail.innerText = car.Detalles
		detail.setAttribute("class", "detail");
		
		var ayo = document.createElement("span");
		ayo.innerText = car.Ayo;
		ayo.setAttribute("class", "ayo");
		
		var button = document.createElement("a");
		button.innerText = "Reservar";
		button.setAttribute("class", "button");
		button.setAttribute("href","reserva.jsp");
		
		figure.appendChild(img);
		figure.appendChild(figcaption);
		figure.appendChild(detail);
		figure.appendChild(document.createElement("br"));
		figure.appendChild(span);
		figure.appendChild(ayo);
		figure.appendChild(button);
		
		body.appendChild(figure)
	})})
	
}

function createRequest() {
	var http = new XMLHttpRequest();
	http.onload = function () {
		if(this.readyState == 4 && this.status == 200) {
			arrayCar = JSON.parse(this.responseText);
			getData();
		}
	};
	console.log(http)
	// Preparar la peticion por AJAX
	http.open("GET", "../AJAXCheckCochesController", true);
	http.send();
	
	
}

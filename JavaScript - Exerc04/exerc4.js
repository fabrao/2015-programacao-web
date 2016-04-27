function exibe() {
	var n1 = document.querySelector("[name=valor]");

	var result="";
	var aux = divisores(n1.value);
	
	for(var i=0; i<aux.length; i++){
		result = result.concat("<li>",aux[i],"</li>");
	}
	
	document.getElementById("DivResult").innerHTML=result;
}
			
function divisores(num1) {
	var result=0;
	var n1= parseFloat(num1);
	var lista = [];
	
	for(var i=n1; i>0; i--){
		if(n1 % i == 0){
			lista.unshift(i);
		}
	}
	
	return lista;
}
	
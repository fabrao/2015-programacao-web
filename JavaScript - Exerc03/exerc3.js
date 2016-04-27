function altera() {
	var n1 = document.querySelector("[name=valor1]");
	var n2 = document.querySelector("[name=valor2]");
	var op = document.querySelector("[name=operador]");

	document.getElementById("h1result").innerHTML=calcula(n1.value, n2.value, op.value);
}
			
function calcula(num1, num2, op) {
	var result=0;
	var n1= parseFloat(num1);
	var n2= parseFloat(num2);
				
	switch(op){
		case "+": result= n1+n2; break;
		case "-": result= n1-n2; break;
		case "/": result= n1/n2; break;
		case "*": result= n1*n2; break;
		default: alert("Erro em 'FCalcula'");
	}
	return result;
}
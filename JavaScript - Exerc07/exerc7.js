function Exibir() {
	var VetorNum = [];
	var opcao = confirm("OK para Crescente ou Cancelar para Decrescente");
	
	
	
	if(opcao == true){
		VetorNum = Crescente();
	}else{
		VetorNum = Decrescente();
	}
	
	var result="";
	
	for(var i=0; i<VetorNum.length; i++){
		result = result.concat("<li>"+VetorNum[i]+"</li>");
	}
	
	document.getElementById("ListaLinks").innerHTML=result;
	
}


var ArrayNum = [4,3,2,1,0,5,6,7,8,9];

function Crescente(){
	var aux;
	for(var i=0; i<ArrayNum.length; i++){
		for(var j=i+1; j<ArrayNum.length; j++){
			if( ArrayNum[i] > ArrayNum[j] ){
				aux = ArrayNum[i];
				ArrayNum[i] = ArrayNum[j];
				ArrayNum[j] = aux;
			}
		}
	}
	return ArrayNum;
}

function Decrescente(){
	var aux;
	for(var i=0; i<ArrayNum.length; i++){
		for(var j=i+1; j<ArrayNum.length; j++){
			if( ArrayNum[i] < ArrayNum[j] ){
				aux = ArrayNum[i];
				ArrayNum[i] = ArrayNum[j];
				ArrayNum[j] = aux;
			}
		}
	}
	return ArrayNum;
}

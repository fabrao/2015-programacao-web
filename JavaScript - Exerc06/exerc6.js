window.onload = function(){
	FLink();
}

function FLink() {
	
	var VNomes = [	"Uol", "Bol", "Facebook", "Google", "Baixaki",	
					"Yahoo", "Bing", "UTFPR",	"MercadoLivre", "Lenovo"];
	
	var VLinks = [	"http://www.uol.com.br/" , "http://www.bol.com.br/" , 
					"http://www.facebook.com/" , "http://www.google.com/" , 
					"http://www.baixaki.com/" ,	"http://www.yahoo.com/" , 
					"http://www.bing.com/" , "http://www.utfpr.edu.br/" , 
					"http://www.mercadolivre.com.br/" , "http://www.lenovo.com/" ];
	
	var result="";
	
	for(var i=0; i<VNomes.length; i++){
		result = result.concat("<li><a href=",VLinks[i],">",VNomes[i],"</a></li>");
	}
	
	document.getElementById("ListaLinks").innerHTML=result;
	
}

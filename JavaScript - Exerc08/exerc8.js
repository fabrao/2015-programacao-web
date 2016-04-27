function mudaImagem(i) { 
    if(i == 1){
		document.getElementById("imagem1").src="imagem2.jpg";
	}else if(i == 2){
		document.getElementById("imagem1").src="imagem1.jpg";
	}
}

function trocaImagem(img){
	var src = img.src.substr(img.src.lastIndexOf('/') + 1, img.src.length);
	//console.log(src);

	if(src == "imagem2.jpg"){
		document.getElementById("imagem1").src = "imagem3.jpg";
	}else if(src == "imagem3.jpg"){
		document.getElementById("imagem1").src = "imagem1.jpg";
	}else if(src == "imagem1.jpg"){
		document.getElementById("imagem1").src = "imagem2.jpg";
	}
}
	
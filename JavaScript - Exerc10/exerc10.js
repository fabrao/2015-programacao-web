function AlteraCor(){

	var color;
	color = document.getElementById("FontColor").color;
	//console.log(color);
		
	if(color == ""){
		document.getElementById("FontColor").color="red";
	}else if(color == "red"){
		document.getElementById("FontColor").color="blue";
	}else if(color == "blue"){
		document.getElementById("FontColor").color="black";
	}else if(color == "black"){
		document.getElementById("FontColor").color="red";
	}
	
	//console.log(color);
}
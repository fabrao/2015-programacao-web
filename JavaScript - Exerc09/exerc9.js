function contador() { 
	/*
	for(var i=1; i<10; i++){
		setTimeout(function(){altera(i);},(i*1000));
	}
	*/
	setTimeout(function(){altera(0);},0000);
	setTimeout(function(){altera(1);},1000);
	setTimeout(function(){altera(2);},2000);
	setTimeout(function(){altera(3);},3000);
	setTimeout(function(){altera(4);},4000);
	setTimeout(function(){altera(5);},5000);
	setTimeout(function(){altera(6);},6000);
	setTimeout(function(){altera(7);},7000);
	setTimeout(function(){altera(8);},8000);
	setTimeout(function(){altera(9);},9000);
	setTimeout(function(){altera(10);},10000);
	
}

function altera(tempo){
	document.getElementById("h1Contador").innerHTML=tempo;
}
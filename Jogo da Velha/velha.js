var x = "x.png";
var o = "o.png";
var vazio = "vazio.png";

var pausa = 0;
var todos= 0;
var q11= 0;
var q12= 0;
var q13= 0;
var q21= 0;
var q22= 0;
var q23= 0;
var q31= 0;
var q32= 0;
var q33= 0;

var qtemp="";
var ok = 0;
var qvalor = 0;
var choice=9;
var numRandom = 0;
var compTurno= 0; 
var contTurno= 0;
var vitoriaPlayer = 0;
var vitoriaPC = 0;
var empate = 0;

function logicaJogada() {
	if ((q11==1)&&(q12==1)&&(q13==1)) todos=1;
	if ((q11==1)&&(q21==1)&&(q31==1)) todos=1;
	if ((q11==1)&&(q22==1)&&(q33==1)) todos=1;
	if ((q12==1)&&(q22==1)&&(q32==1)) todos=1;
	if ((q21==1)&&(q22==1)&&(q23==1)) todos=1;
	if ((q31==1)&&(q32==1)&&(q33==1)) todos=1;
	if ((q13==1)&&(q23==1)&&(q33==1)) todos=1;
	if ((q31==1)&&(q22==1)&&(q13==1)) todos=1;
	if ((q11==2)&&(q12==2)&&(q13==2)) todos=2;
	if ((q11==2)&&(q21==2)&&(q31==2)) todos=2;
	if ((q11==2)&&(q22==2)&&(q33==2)) todos=2;
	if ((q12==2)&&(q22==2)&&(q32==2)) todos=2;
	if ((q21==2)&&(q22==2)&&(q23==2)) todos=2;
	if ((q31==2)&&(q32==2)&&(q33==2)) todos=2;
	if ((q13==2)&&(q23==2)&&(q33==2)) todos=2;
	if ((q31==2)&&(q22==2)&&(q13==2)) todos=2;
	if ((q11 != 0)&&(q12 != 0)&&(q13 != 0)&&(q21 != 0)&&(q22 != 0)&&(q23 != 0)&&(q31 != 0)&&(q32 != 0)&&(q33 != 0)&&(todos == 0)) todos = 3;
} 

function logicaVitoria() {
	if ((q11==2)&&(q12==2)&&(q13== 0)&&(qtemp=="")) qtemp="Q13";
	if ((q11==2)&&(q12== 0)&&(q13==2)&&(qtemp=="")) qtemp="Q12";
	if ((q11== 0)&&(q12==2)&&(q13==2)&&(qtemp=="")) qtemp="Q11";
	if ((q11==2)&&(q21==2)&&(q31== 0)&&(qtemp=="")) qtemp="Q31";
	if ((q11==2)&&(q21== 0)&&(q31==2)&&(qtemp=="")) qtemp="Q21";
	if ((q11== 0)&&(q21==2)&&(q31==2)&&(qtemp=="")) qtemp="Q11";
	if ((q11==2)&&(q22==2)&&(q33== 0)&&(qtemp=="")) qtemp="Q33";
	if ((q11==2)&&(q22== 0)&&(q33==2)&&(qtemp=="")) qtemp="Q22";
	if ((q11== 0)&&(q22==2)&&(q33==2)&&(qtemp=="")) qtemp="Q11";
	if ((q12==2)&&(q22==2)&&(q32== 0)&&(qtemp=="")) qtemp="Q32";
	if ((q12==2)&&(q22== 0)&&(q32==2)&&(qtemp=="")) qtemp="Q22";
	if ((q12== 0)&&(q22==2)&&(q32==2)&&(qtemp=="")) qtemp="Q12";
	if ((q21==2)&&(q22==2)&&(q23== 0)&&(qtemp=="")) qtemp="Q23";
	if ((q21==2)&&(q22== 0)&&(q23==2)&&(qtemp=="")) qtemp="Q22";
	if ((q21== 0)&&(q22==2)&&(q23==2)&&(qtemp=="")) qtemp="Q21";
	if ((q31==2)&&(q32==2)&&(q33== 0)&&(qtemp=="")) qtemp="Q33";
	if ((q31==2)&&(q32== 0)&&(q33==2)&&(qtemp=="")) qtemp="Q32";
	if ((q31== 0)&&(q32==2)&&(q33==2)&&(qtemp=="")) qtemp="Q31";
	if ((q13==2)&&(q23==2)&&(q33== 0)&&(qtemp=="")) qtemp="Q33";
	if ((q13==2)&&(q23== 0)&&(q33==2)&&(qtemp=="")) qtemp="Q23";
	if ((q13== 0)&&(q23==2)&&(q33==2)&&(qtemp=="")) qtemp="Q13";
	if ((q31==2)&&(q22==2)&&(q13== 0)&&(qtemp=="")) qtemp="Q13";
	if ((q31==2)&&(q22== 0)&&(q13==2)&&(qtemp=="")) qtemp="Q22";
	if ((q31== 0)&&(q22==2)&&(q13==2)&&(qtemp=="")) qtemp="Q31";
}

function logicaDerrota() {
	if ((q11==1)&&(q12==1)&&(q13==0)&&(qtemp=="")) qtemp="Q13";
	if ((q11==1)&&(q12==0)&&(q13==1)&&(qtemp=="")) qtemp="Q12";
	if ((q11==0)&&(q12==1)&&(q13==1)&&(qtemp=="")) qtemp="Q11";
	if ((q11==1)&&(q21==1)&&(q31==0)&&(qtemp=="")) qtemp="Q31";
	if ((q11==1)&&(q21==0)&&(q31==1)&&(qtemp=="")) qtemp="Q21";
	if ((q11==0)&&(q21==1)&&(q31==1)&&(qtemp=="")) qtemp="Q11";
	if ((q11==1)&&(q22==1)&&(q33==0)&&(qtemp=="")) qtemp="Q33";
	if ((q11==1)&&(q22==0)&&(q33==1)&&(qtemp=="")) qtemp="Q22";
	if ((q11==0)&&(q22==1)&&(q33==1)&&(qtemp=="")) qtemp="Q11";
	if ((q12==1)&&(q22==1)&&(q32==0)&&(qtemp=="")) qtemp="Q32";
	if ((q12==1)&&(q22==0)&&(q32==1)&&(qtemp=="")) qtemp="Q22";
	if ((q12==0)&&(q22==1)&&(q32==1)&&(qtemp=="")) qtemp="Q12";
	if ((q21==1)&&(q22==1)&&(q23==0)&&(qtemp=="")) qtemp="Q23";
	if ((q21==1)&&(q22==0)&&(q23==1)&&(qtemp=="")) qtemp="Q22";
	if ((q21==0)&&(q22==1)&&(q23==1)&&(qtemp=="")) qtemp="Q21";
	if ((q31==1)&&(q32==1)&&(q33==0)&&(qtemp=="")) qtemp="Q33";
	if ((q31==1)&&(q32==0)&&(q33==1)&&(qtemp=="")) qtemp="Q32";
	if ((q31==0)&&(q32==1)&&(q33==1)&&(qtemp=="")) qtemp="Q31";
	if ((q13==1)&&(q23==1)&&(q33==0)&&(qtemp=="")) qtemp="Q33";
	if ((q13==1)&&(q23==0)&&(q33==1)&&(qtemp=="")) qtemp="Q23";
	if ((q13==0)&&(q23==1)&&(q33==1)&&(qtemp=="")) qtemp="Q13";
	if ((q31==1)&&(q22==1)&&(q13==0)&&(qtemp=="")) qtemp="Q13";
	if ((q31==1)&&(q22==0)&&(q13==1)&&(qtemp=="")) qtemp="Q22";
	if ((q31==0)&&(q22==1)&&(q13==1)&&(qtemp=="")) qtemp="Q31";
}


function verificaJogadas() {
	if ((qtemp=="Q11")&&(q11==0)){
		ok=1;
		if (qvalor==0) q11=1;
		if (qvalor==1) q11=2;
	}
	if ((qtemp=="Q12")&&(q12==0)){
		ok=1;
		if (qvalor==0) q12=1;
		if (qvalor==1) q12=2;
	}
	if ((qtemp=="Q13")&&(q13==0)){
		ok=1;
		if (qvalor==0) q13=1;
		if (qvalor==1) q13=2;
	}
	if ((qtemp=="Q21")&&(q21==0)){
		ok=1;
		if (qvalor==0) q21=1;
		if (qvalor==1) q21=2;
	}
	if ((qtemp=="Q22")&&(q22==0)){
		ok=1;
		if (qvalor==0) q22=1;
		if (qvalor==1) q22=2;
	}
	if ((qtemp=="Q23")&&(q23==0)){
		ok=1
		if (qvalor==0) q23=1;
		if (qvalor==1) q23=2;
	}
	if ((qtemp=="Q31")&&(q31==0)){
		ok=1
		if (qvalor==0) q31=1;
		if (qvalor==1) q31=2;
	}
	if ((qtemp=="Q32")&&(q32==0)){
		ok=1;
		if (qvalor==0) q32=1;
		if (qvalor==1) q32=2;
	}
	if ((qtemp=="Q33")&&(q33==0)){
		ok=1;
		if (qvalor==0) q33=1; 
		if (qvalor==1) q33=2; 
	}
}

function jogadaPlayer(qNome) {
	pausa = 0;
	if (todos!=0){
		alert("O jogo acabou! Comece um novo jogo");
	}
	if (todos==0) {
		qvalor = 0;
		ok = 0;
		qtemp=qNome;
		verificaJogadas();
		if (ok==1){
			document.images[qNome].src = x;
		}
		if (ok==0){
			alert("Jogada inválida");
			pausa=1;
		}
		statusJogo();
		if ((todos==0)&&(pausa==0)) jogadaComputador();
	}
}


function jogadaComputador(){
	qtemp="";
	ok = 0;
	qvalor=1;
	logicaVitoria();
	logicaDerrota();
	verificaJogadas();
	while(ok==0) {
		numRandom=Math.random()
		compTurno=Math.round((choice-1)*numRandom)+1;
		if (compTurno==1) qtemp="Q11";
		if (compTurno==2) qtemp="Q12";
		if (compTurno==3) qtemp="Q13";
		if (compTurno==4) qtemp="Q21";
		if (compTurno==5) qtemp="Q22";
		if (compTurno==6) qtemp="Q23";
		if (compTurno==7) qtemp="Q31";
		if (compTurno==8) qtemp="Q32";
		if (compTurno==9) qtemp="Q33";
		verificaJogadas();
	}
	document.images[qtemp].src= o;
	statusJogo();
}

function statusJogo() {
	logicaJogada();
	if (todos==1){ alert("Parabéns, você venceu!"); vitoriaPlayer++; }
	if (todos==2){ alert("Que pena, você perdeu!"); vitoriaPC++; }
	if (todos==3){ alert("O jogo terminou empatado!"); empate++; }
	if (todos!=0) {
		document.jogo.jogador.value = vitoriaPlayer;
		document.jogo.computador.value = vitoriaPC;
		document.jogo.empates.value = empate;
   }
}

function recomecar() {
	todos = 0;
	q11 = 0;
	q12 = 0;
	q13 = 0;
	q21 = 0;
	q22 = 0;
	q23 = 0;
	q31 = 0;
	q32 = 0;
	q33 = 0;
	qtemp="";
	ok = 0;
	qvalor = 0;
	choice=9;
	numRandom = 0;
	compTurno= 0; 
	document.images.Q11.src= vazio;
	document.images.Q12.src= vazio;
	document.images.Q13.src= vazio;
	document.images.Q21.src= vazio;
	document.images.Q22.src= vazio;
	document.images.Q23.src= vazio;
	document.images.Q31.src= vazio;
	document.images.Q32.src= vazio;
	document.images.Q33.src= vazio;
	if (contTurno==0){ 
		contTurno=2; 
		jogadaComputador(); 
	}
	contTurno--;
}
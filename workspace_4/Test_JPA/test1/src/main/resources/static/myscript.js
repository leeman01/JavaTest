/**
 * 
 */
document.getElementById("equal").addEventListener('click',"calculate");

function calculate(){
	let x = document.getElementById("x").value ;
	let y = document.getElementById("y").value ;
	document.getElementById("final").value = parseInt(x) + PparseInt(y) ;
}
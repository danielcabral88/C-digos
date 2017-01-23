<?php 

 function Query($conecta,$sql)
{
	
		return mysqli_query($conecta, $sql);

}

function ListaGenericas($conecta,$sql){

	$genericos = array();
	$resultado = mysqli_query($conecta, $sql);
	while($generico= mysqli_fetch_assoc($resultado)) {
		array_push($genericos, $egenerico);
	}
	return $genericos;
}


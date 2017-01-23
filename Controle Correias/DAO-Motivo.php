<?php 
function ListaMotivos($conecta) // implementado por Daniel 01/12/2014
{
	$ListaMotivos = array();
	$resultado = mysqli_query($conecta, "select * from aux_motivo");
	while($motivo = mysqli_fetch_assoc($resultado)) {
		array_push($ListaMotivos, $motivo);
	}
	return $ListaMotivos;
}


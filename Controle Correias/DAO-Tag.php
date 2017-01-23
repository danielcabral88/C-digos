<?php 

function insereTag($conecta,$tag, $descricao, $comprimento_correia) //implementado por Daniel 27/11/2014
{
	$sql = "insert into ativo (tag, descricao, comprimento_correia) values ('{$tag}','{$descricao}','{$comprimento_correia}')";
		return mysqli_query($conecta, $sql);
}

function ListaAtivos($conecta){ // implementado por Daniel 27/11/2014

	$listaAtivos = array();
	$resultado = mysqli_query($conecta, "select * from ativo");
	while($ativo = mysqli_fetch_assoc($resultado)) {
		array_push($listaAtivos, $ativo);
	}
	return $listaAtivos;
}

<?php 

 function insereTroca($conecta, $data, $motivo, $obs, $os, $custo, $qtd_troca, $ativo) //implementado por Daniel 01/12/2014
{
	$sql = "insert into troca (data, motivo, obs, os, custo, qtd_troca, ativo) 
	values ('{$data}','{$motivo}','{$obs}','{$os}','{$custo}','{$qtd_troca}','{$ativo}')";
		return mysqli_query($conecta, $sql);
}

function ListaTrocas($conecta, $id_ativo){ // implementado por Daniel 01/12/2014
	$ListaTrocas = array();
	$resultado = mysqli_query($conecta, "select * from troca where ativo = ('{$id_ativo}')");
	while($troca = mysqli_fetch_assoc($resultado)) {
		array_push($ListaTrocas, $troca);
	}
	return $ListaTrocas;
}

function ListaTrocasTag($conecta, $tag_ativo){ // implementado por Daniel 01/12/2014
	$ListaTrocas = array();
	$resultado = mysqli_query($conecta, "select t.id, t.data, t.motivo, t.obs, t.os, t.custo, t.qtd_troca, t.ativo from troca as t left outer join ativo as a on a.id = t.ativo where a.tag = ('{$tag_ativo}')");
	while($troca = mysqli_fetch_assoc($resultado)) {
		array_push($ListaTrocas, $troca);
	}
	return $ListaTrocas;
}

function BuscaTroca($conecta, $id){
	$query = "select * from troca where id = ('{$id}')";
	$result = mysqli_query($conecta,$query);
	return mysqli_fetch_assoc($result);
}
	



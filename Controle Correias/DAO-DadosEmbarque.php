<?php
 function insereNavio($conecta,$nome_navio, $carga, $data_desatracacao, $data_atracaco)
 {
	$sql = "insert into dados_embarque (nome_navio,carga,data_desatracacao,data_atracacao) values ('{$nome_navio}','{$carga}','{$data_desatracacao}','{$data_atracacao}')";
	return mysqli_query($conecta, $sql);
}
function ListaNavios($conecta) // Implementado por Daniel 01/12/2014
{

	$navios = array();
	$resultado = mysqli_query($conecta, "select * from dados_embarque");
	while($navio = mysqli_fetch_assoc($resultado)) {
		array_push($navios, $navio);
	}
	return $navios;
}
function BuscarAtivoData($conecta, $id_ativo, $data_troca) // Implementado por Daniel 01/12/2014
{
	$navios = array();
	$resultado = mysqli_query($conecta,"select * from dados_embarque where data_desatracacao between '{$data_troca}' and (select troca.data from troca where troca.ativo = '{$id_ativo}' and troca.data > '{$data_troca}' order by troca.data asc limit 1)");
	while($navio = mysqli_fetch_assoc($resultado)) {
		array_push($navios, $navio);
	}	
	return $navios;
}


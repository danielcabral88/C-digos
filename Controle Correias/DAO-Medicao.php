<?php 

 function insereMedicao($conecta,$data,$espessura, $ativo) //implementado por Daniel 01/12/2014
{
	$sql = "insert into medicao (data, espessura, ativo) 
	values ('{$data}','{$espessura}','{$ativo}')";
		return mysqli_query($conecta, $sql);
}

function BuscaUltima($conecta, $id_ativo){ // implementado por Daniel 01/12/2014

	$query = "select * from troca where ativo = ('{$id_ativo}') order by data desc limit 1";
	$result = mysqli_query($conecta,$query);
	return mysqli_fetch_assoc($result);
}


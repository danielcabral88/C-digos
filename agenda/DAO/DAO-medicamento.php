<?php 

 function insereMedicamento($conecta,$medicamento)
{
	$sql = "insert into medicamento (nome_medicamento) values ('{$medicamento}')";
		return mysqli_query($conecta, $sql);

}

function ListaMedicamentos($conecta){

	$medicamentos = array();
	$resultado = mysqli_query($conecta, "select *from medicamento");
	while($medicamento = mysqli_fetch_assoc($resultado)) {
		array_push($medicamentos, $medicamento);
	}
	return $medicamentos;
}

function RemoveMedicamento($conecta,$id)
{
	$query = "delete from medicamento where idMedicamento = {$id}";
	return mysqli_query($conecta, $query);
}


function buscarMedicamento($conecta,$nome){

	$query = "select idMedicamento from medicamento where nome_medicamento = ('{$nome}')";
	$result = mysqli_query($conecta,$query);
	return mysqli_fetch_assoc($result);
}









 ?>
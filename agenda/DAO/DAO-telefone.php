<?php 

 function insereTelefone($conecta,$telefone,$ddd,$tipotelefone,$complemento,$paciente,$endereco)
{
	$sql = "insert into telefone (numero,ddd,tipoTelefone,complemento,Paciente_idPaciente, Paciente_Endececo_idEndececo) values ('{$telefone}','{$ddd}','{$tipotelefone}','{$complemento}','{$paciente}','{$endereco}')";
		return mysqli_query($conecta, $sql);

}

function ListaTelefones($conecta){

	$telefones = array();
	$resultado = mysqli_query($conecta, "select *from telefone");
	while($telefone = mysqli_fetch_assoc($resultado)) {
		array_push($telefones, $telefone);
	}
	return $medicamentos;
}

function RemoveTelefone($conecta,$id)
{
	$query = "delete from telefone where idTelefone = {$id}";
	return mysqli_query($conecta, $query);
}


function buscarTelefone($conecta,$numero){

	$query = "select idTelefone from telefone where numero = ('{$numero}')";
	$result = mysqli_query($conecta,$query);
	return mysqli_fetch_assoc($result);
}









 ?>
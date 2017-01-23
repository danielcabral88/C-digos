<?php 

 function inserePrescricao($conecta,$dosagem,$administracao,$tempoUso,$id)
{
	$sql = "insert into prescricao (dosagem,administracao,tempoUso,Medicamento_idMedicamento) values ('{$dosagem}','{$administracao}','{$tempoUso}',{$id})";
		return mysqli_query($conecta, $sql);

}

function ListaPrescricoes($conecta){

	$prescricoes = array();
	$resultado = mysqli_query($conecta, "select *from prescricao");
	while($prescicao = mysqli_fetch_assoc($resultado)) {
		array_push($prescricoes, $prescricao);
	}
	return $prescricaos;
}

function RemovePrescricao($conecta,$id)
{
	$query = "delete from prescricao where idPrescricao= {$id}";
	return mysqli_query($conecta, $query);
}


function buscarPrescricao($conecta,$id){
	
	$query = "select *from prescricao where idPrescricao = {$id}";
	return mysqli_query($conecta,$query);
}






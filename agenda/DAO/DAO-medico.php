<?php 

 function insereMedico($conecta,$medico,$crm,$senha)
{
	$sql = "insert into medico (nome,crm,senha) values ('{$medico}','{$crm}','{$senha}')";
		return mysqli_query($conecta, $sql);

}

function ListaMedicos($conecta){

	$medicos = array();
	$resultado = mysqli_query($conecta, "select *from medico");
	while($medico = mysqli_fetch_assoc($resultado)) {
		array_push($medicos, $medico);
	}
	return $medicos;
}

function RemoveMedico($conecta,$id)
{
	$query = "delete from medico where idMedico = {$id}";
	return mysqli_query($conecta, $query);
}


function buscarMedico($conecta,$nome, $senha){
	$senhaMd5 = md5($senha);
	$query = "select  *from medico where nome = '{$nome}' and 
                                           senha='{$senhaMd5}'";
	$result = mysqli_query($conecta,$query);
	return mysqli_fetch_assoc($result);
}









 ?>
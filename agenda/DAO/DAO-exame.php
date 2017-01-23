<?php 

 function insereExame($conecta,$exame)
{
	$sql = "insert into exame (nome_exame) values ('{$exame}')";
		return mysqli_query($conecta, $sql);

}

function ListaExame($conecta){

	$exames = array();
	$resultado = mysqli_query($conecta, "select *from exame");
	while($exame = mysqli_fetch_assoc($resultado)) {
		array_push($exames, $exame);
	}
	return $exames;
}

function RemoveExame($conecta,$id)
{
	$query = "delete from exame where idExame = {$id}";
	return mysqli_query($conecta, $query);
}


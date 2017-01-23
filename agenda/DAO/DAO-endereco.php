<?php 

 function insereEndereco($conecta,$endereco,$numero,$complemento,$bairro,$municipio,$cep,$uf)
{
	$sql = "insert into endececo (logradoudo,numero,complemento,bairro,municipio,cep,uf) values ('{$endereco}','{$numero}','{$complemento}','{$bairro}','{$municipio}','{$cep}','{$uf}')";
		return mysqli_query($conecta, $sql);

}

function ListaEnderecos($conecta){

	$enderecos = array();
	$resultado = mysqli_query($conecta, "select *from endececo");
	while($endereco= mysqli_fetch_assoc($resultado)) {
		array_push($enderecos, $endereco);
	}
	return $enderecos;
}

function RemoveEndereco($conecta,$id)
{
	$query = "delete from endececo where idEndececo = {$id}";
	return mysqli_query($conecta, $query);
}


function buscarEndereco($conecta,$id){
	
	$query = "select *from endececo where logradoudo = ('{$id}')";
	$result = mysqli_query($conecta,$query);
	return mysqli_fetch_assoc($result);
}



<?php 

 function inserePedido($conecta,$cliente,$data) //implementado por Daniel 27/11/2014
{
	$sql = "insert into pedido (cliente, data) values ('{$cliente}','{$data}')";
		return mysqli_query($conecta, $sql);
}

function ListaPedidos($conecta, $cliente){ // implementado por Daniel 27/11/2014

	$listaPedidos = array();
	$resultado = mysqli_query($conecta, "select * from pedido where cliente = ('{cliente}')");
	while($pedido = mysqli_fetch_assoc($resultado)) {
		array_push($listaPedidos, $pedido);
	}
	return $listaPedidos;
}

function RemovePedido($conecta,$id)
{
	$query = "delete from pedido where id = {$id}";
	return mysqli_query($conecta, $query);
}

function BuscarPedido($conecta,$id){

	$query = "select * from pedido where id = ('{$id}')";
	$result = mysqli_query($conecta,$query);
	return mysqli_fetch_assoc($result);
}


<?php 
 include ("../conecta.php");
 include ("../DAO/DAO-medicamento.php");


$nome = $_GET['medicamento'];

if( insereMedicamento($conexao, $nome)){ 
	$_SESSION["success"] = "O produto <?= $nome ?> foi adicionado.";
 } else {
	$msg = mysqli_error($conexao);

	$_SESSION["danger"] = "O produto <?= $nome ?> não foi adicionado: <?= $msg?>"

}
  header("Location: ../medicamentos.php");
  die();
include("../rodape.php"); ?>			

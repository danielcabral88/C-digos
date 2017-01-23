<?php 
 include ("../conecta.php");
 include ("../DAO/DAO-exame.php");


$nome = $_GET['exame'];

if( insereExame($conexao, $nome)){ 
	$_SESSION["success"] = "O produto <?= $nome ?> foi adicionado.";
 } else {
	$msg = mysqli_error($conexao);

	$_SESSION["danger"] = "O produto <?= $nome ?> não foi adicionado: <?= $msg?>";
}
 
 header("Location: ../exame.php");
  die(); ?>			

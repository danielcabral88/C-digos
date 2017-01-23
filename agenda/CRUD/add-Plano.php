<?php  		
			
 include ("../conecta.php");
 include ("../DAO/DAO-PlanoSaude.php");


$nome = $_GET['plano'];

if( inserePlano($conexao, $nome)){ 
	$_SESSION["success"] = "O produto <?= $nome ?> foi adicionado.";
 } else {
	$msg = mysqli_error($conexao);

	$_SESSION["danger"] = "O produto <?= $nome ?> não foi adicionado: <?= $msg?></p>";
}
 header("Location: ../planodesaude.php");
  die();
   ?>			

<?php  		
 include("../conecta.php");			
 include("../DAO/DAO-exame.php"); 

 $id = $_POST['id'];
 RemoveExame($conexao, $id);
 
  $_SESSION["success"] = "Medicamento apagado com sucesso.</p>";
 
 header("Location: ../Exame.php");
  die();?>
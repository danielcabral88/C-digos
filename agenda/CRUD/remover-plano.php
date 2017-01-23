<?php 	
 include("../conecta.php");			
 include("../DAO/DAO-PlanoSaude.php"); 

 $id = $_POST['id'];
 RemovePlano($conexao, $id);
 
  $_SESSION["success"] = "Medicamento apagado com sucesso.";
   header("Location: ../planodesaude.php");
  die(); ?>
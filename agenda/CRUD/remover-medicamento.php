<?php 	
 include("../conecta.php");			
 include("../DAO/DAO-medicamento.php"); 

 $id = $_POST['id'];
 RemoveMedicamento($conexao, $id);
 $_SESSION["success"] = "Medicamento apagado com sucesso.";


 header("Location: ../medicamentos.php");
  die(); ?>
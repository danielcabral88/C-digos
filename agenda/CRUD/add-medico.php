<?php
  include("../conecta.php");
  include("../DAO/DAO-medico.php");
  
$senhaMd5 = md5($_POST["senha"]);
$medico = $_POST["medico"];
   if (insereMedico($conexao,$medico,$_POST["crm"],$senhaMd5)) {
  
 $_SESSION["success"] = "Medico <?= $medico ?> foi adicionado.";
 } else {
  $msg = mysqli_error($conexao);

  $_SESSION["danger"] = "O Medico <?= $medico ?> não foi adicionado: <?= $msg?></p>";

}
 header("Location: ../index.php");
 die();
include("../rodape.php");
?>
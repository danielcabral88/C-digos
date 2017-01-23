<?php
  include("conecta.php");
  include("DAO/DAO-medico.php");
  include("logica-usuario.php");
   
   $usuario = buscarMedico($conexao, $_POST["name"], $_POST["senha"]);

   if ($usuario != null) {
   	   logaUsuario($_POST["name"]);
       $_SESSION["success"] = "Login realizado com sucesso !";
       header("Location:principal.php");
   
   } else {
       $_SESSION["danger"] = "Autenticação falhou !";
       header("Location: index.php");
   }
   die();
?>
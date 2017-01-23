<?php
session_start();

$nome;

function usuarioEstaLogado() {
	return isset($_SESSION["usuario_logado"]);
}
 
function verificaUsuario() {
  if(!usuarioEstaLogado()) {
  	 $_SESSION["danger"] = "Você não tem permissão para acessar esta página !";
     header("Location: index.php");
     die();
  }
}

function usuarioLogado() {
    return $_SESSION["usuario_logado"];
}


function usuarioNome() {
    return $nome;
}
function logaUsuario($nome1) {
  $_SESSION["usuario_logado"] = $nome1;
  $nome = $nome1;
}

function logout() {
	session_destroy();
  session_start();
  $_SESSION["success"] = "Logout realizado com sucesso"; 
}



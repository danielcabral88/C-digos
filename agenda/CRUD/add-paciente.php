<?php 

include ("../DAO/DAO-endereco.php");
include ("../DAO/DAO-telefone.php");
include ("../DAO/DAO-paciente.php");
include ("../DAO/DAO-PlanoSaude.php");
include ("../conecta.php");

$endereco = $_GET['logradouro'];
$numero = $_GET['numero'];
$complemento = $_GET['complemento'];
$bairro = $_GET['bairro'];
$municipio = $_GET['municipio'];
$cep = $_GET['cep'];
$uf = $_GET['uf'];

if(insereEndereco($conexao,$endereco,$numero,$complemento,$bairro,$municipio,$cep,$uf)){ 
	$_SESSION["success"] = "o endereco  foi adicionado.</p>";
 } else {
	$msg = mysqli_error($conexao);

	$_SESSION["danger"] = "o endereco não foi adicionado: <?= $msg?>";

}
 
 
     $idEndereco = buscarEndereco($conexao,$endereco);

$nome_crianca = $_GET['paciente'];
$nomeMae = $_GET['nomemae'];
$nomePai = $_GET['nomepai'];
$dataNascimento = $_GET['datanascimento'];
$sexo = "masculino";
$endereco = $idEndereco['idEndececo'];
$planosaude = $_GET['planosaude'];


$idPlano = buscarPlano($conexao,$planosaude);

//o erro tava na função mysqli_numrows pq tu tava passando um array e não uma consu


if(sizeof($idPlano)==0){ 
 
     inserePlano($conexao,$planosaude);
     $idPlano = buscarPlano($conexao,$planosaude);

 }
   $idPlano = $idPlano['idPlanoSaude'];

if( inserePaciente($conexao,$nome_crianca,$nomeMae,$nomePai,$dataNascimento,$sexo,$endereco,$idPlano)){ 
	$_SESSION["success"] = "o paciente  foi adicionado.</p>p";} else {
	$msg = mysqli_error($conexao);

	$_SESSION["danger"] = "o paciente não foi adicionado: <?= $msg?>";

}
     $idPaciente = buscarPaciente($conexao,$nome_crianca);


$telefone = $_GET['numerofixo'];
$ddd = $_GET['dddfixo'];
$tipotelefone = "fixo";
$complementotele = $_GET['complementofixo'];
$paciente = $idPaciente['idPaciente'];
$endereco = $idEndereco['idEndececo'];

if( insereTelefone($conexao,$telefone,$ddd,$tipotelefone,$complementotele,$paciente,$endereco)){ 
	$_SESSION["success"] = "o telefone1  foi adicionado."
 } else {
	$msg = mysqli_error($conexao);

	$_SESSION["danger"] = "o telefone1 não foi adicionado: <?= $msg?>";

}
 
  
$telefone1 = $_GET['numerocelular'];
$ddd1 = $_GET['dddcelular'];
$tipotelefone1 = "celular";
$complementotele1 = $_GET['complementocelular'];
$paciente1 = $idPaciente['idPaciente'];
$endereco1 = $idEndereco['idEndececo'];

   if(insereTelefone($conexao,$telefone1,$ddd1,$tipotelefone1,$complementotele1,$paciente1,$endereco1)){ 
	$_SESSION["success"] ="o telefone2  foi adicionado.";
 } else {
	$msg = mysqli_error($conexao);

	$_SESSION["danger"] = "o telefone2 não foi adicionado: <?= $msg?>";

} 
 header("Location: ../paciente-conteudo.php");
  die();
 ?>			


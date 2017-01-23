<?php include("cabecalho.php"); 		
 include("conecta.php");			
 include("DAO-DadosEmbarque.php"); 

$nome = $_POST['nome'];
$carga = $_POST['carga'];
$data_destracacao = $_POST['data_desatracacao'];
$data_atracacao = $_POST['data_atracacao'];

if(insereNavio($conexao, $nome, $carga, $data_desatracacao, $data_atracacao)) { ?>
	<p class="text-success">Troca cadastrada com sucesso.</p>
<?php } else {
	$msg = mysqli_error($conexao);
?>
	<p class="text-danger">Troca não cadastrada: <?= $msg?></p>
<?php
}
?>

<?php include("rodape.php"); ?>			

<?php include("cabecalho.php"); 		
 include("conecta.php");			
 include("DAO-Troca.php"); 

$ativo = $_POST['ativo'];
$data = $_POST['data'];
$motivo = $_POST['motivo'];
$os = $_POST['os'];
$custo = $_POST['custo'];
$qtd_troca = $_POST['qtd_troca'];
$obs = $_POST['obs'];

if(insereTroca($conexao, $data, $motivo, $obs, $os, $custo, $qtd_troca, $ativo)) { ?>
	<p class="text-success">Troca cadastrada com sucesso.</p>
<?php } else {
	$msg = mysqli_error($conexao);
?>
	<p class="text-danger">Troca não cadastrada: <?= $msg?></p>
<?php
}
?>

<?php include("rodape.php"); ?>			

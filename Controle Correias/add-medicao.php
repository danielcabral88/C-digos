<?php include("cabecalho.php"); 		
 include("conecta.php");			
 include("DAO-Medicao.php"); 

$data = $_POST['data'];
$espessura = $_POST['espessura'];
$ativo = $_POST['ativo'];

if(insereMedicao($conexao, $data, $espessura, $ativo)) { ?>
	<p class="text-success">Medição de Espessura cadastrada com sucesso.</p>
<?php } else {
	$msg = mysqli_error($conexao);
?>
	<p class="text-danger">Medição de Espessura não cadastrada: <?= $msg?></p>
<?php
}
?>

<?php include("rodape.php"); ?>			

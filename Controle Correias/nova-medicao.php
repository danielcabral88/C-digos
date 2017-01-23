<?php include("cabecalho.php");
include("conecta.php");
include("DAO-Tag.php");

$ativos = ListaAtivos($conexao);
?>

	<div class = "row">
		<div class="col-sm-3">
		</div>
		<div class="col-sm-6">
			<h3>Cadastrar Nova Troca de Correia</h3>
				<form action ="add-medicao.php" method ="post" class="form-horizontal" role="form">
				        <div class="form-group">
			        		<label class="control-label col-sm-2">Ativo:</label>
			        		<div class="col-sm-10">
			        			<select class="form-control" name="ativo" id="ativo">
			        			<?php foreach($ativos as $ativo) : ?>
			        				<option value="<?=$ativo['id']?>">
			        						<?=$ativo['tag']?>
			        				</option>
			        			<?php endforeach ?>
			        			</select>
			        		</div>
			        	</div>
				        <div class="form-group">
				          <label class="control-label col-sm-2">Data:</label>
				          <div class="col-sm-10">
				            <input type="date" class="form-control" name="data" id="data" placeholder="Digite a data da troca">
				          </div>
				        </div>
				        <div class="form-group">
				          <label class="control-label col-sm-2">Espessura:</label>
				          <div class="col-sm-10">
				            <input type="text" class="form-control" name="espessura" id="espessura" placeholder="Digite a espessura">
				          </div>
				        </div>
				        <div class="form-group">        
				          <div class="col-sm-offset-2 col-sm-10">
				            <button type="submit" class="btn btn-default">Salvar</button>
				          </div>
				        </div>
			     </form>
		</div>
		<div class="col-sm-3">
		</div>
	</div>
<?php include("rodape.php") ?>

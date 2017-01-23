<?php include("cabecalho.php");
include("conecta.php");
include("DAO-Motivo.php");
include("DAO-Tag.php");

$motivos = ListaMotivos($conexao);
$ativos = ListaAtivos($conexao);
?>
	<div class = "row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<h3>Cadastrar Nova Troca de Correia</h3>
				<form action="add-troca.php" method="post" class="form-horizontal" role="form">
				        
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
				            <input type="date" class="form-control" name ='data' id="data" placeholder="Digite a data da troca">
				          </div>
				        </div>
			        	
			        	<div class="form-group">
			        		<label class="control-label col-sm-2">Motivo:</label>
			        		<div class="col-sm-10">
			        			<select class="form-control" name="motivo" id="motivo">
			        			<?php foreach($motivos as $motivo) : ?>
			        				<option value="<?=$motivo['id']?>">
			        						<?=$motivo['descricao']?>
			        				</option>
			        			<?php endforeach ?>
			        			</select>
			        		</div>
			        	</div>
				        
				        <div class="form-group">
				          <label class="control-label col-sm-2">OS:</label>
				          <div class="col-sm-10">
				            <input type="text" class="form-control" name = 'os' id="os" placeholder="Digite o número da OS">
				          </div>
				        </div>
				        
				        <div class="form-group">
				          <label class="control-label col-sm-2">Custo:</label>
				          <div class="col-sm-10">
				            <input type="text" class="form-control" name = 'custo' id="custo" placeholder="Digite o custo da troca">
				          </div>
				        </div>
				        
				        <div class="form-group">
				          <label class="control-label col-sm-2">Quantidade:</label>
				          <div class="col-sm-10">
				            <input type="text" class="form-control" name = 'qtd_troca' id="qtd_troca" placeholder="Quantos metros forma trocados">
				          </div>
				        </div>
				        
				        <div class="form-group">
				          <label class="control-label col-sm-2">Observações:</label>
				          <textarea class="form-control" rows="5" name = 'obs' id="obs"></textarea>
				        </div>
				        
				        <div class="form-group">        
				          <div class="col-sm-offset-2 col-sm-10">
				            <button type="submit" class="btn btn-default">Salvar</button>
				          </div>
				        </div>

			    </form>
		</div>
		<div class="col-sm-3"></div>
	</div>
<?php include("rodape.php") ?>

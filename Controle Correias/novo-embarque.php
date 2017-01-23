<?php include("cabecalho.php") ?>
	<div class = "row">
		<div class="col-sm-3"></div>
		<div class="col-sm-6">
			<h3>Cadastrar Novo Embarque</h3>
				<form action = "add-embarque.php" method = "post" class="form-horizontal" role="form">
				        <div class="form-group">
				          <label class="control-label col-sm-2">Navio:</label>
				          <div class="col-sm-10">
				            <input type="text" class="form-control" name = "nome" id="nome" placeholder="Digite o nome do navio">
				          </div>
				        </div>
				        <div class="form-group">
				          <label class="control-label col-sm-2">Chegada:</label>
				          <div class="col-sm-10">
				            <input type="date" class="form-control" name = "data_atracacao" id="data_atracacao" placeholder="Digite a data de atracação">
				          </div>
				        </div>
				        <div class="form-group">
				          <label class="control-label col-sm-2">Saída:</label>
				          <div class="col-sm-10">
				            <input type="date" class="form-control" name = "data_desatracacao" id="data_desatracacao" placeholder="Digite a data de desatracação">
				          </div>
				        </div>
				        <div class="form-group">
				          <label class="control-label col-sm-2">Carga:</label>
				          <div class="col-sm-10">
				            <input type="text" class="form-control" name = "carga" id="carga" placeholder="Digite a carga arqueada">
				          </div>
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

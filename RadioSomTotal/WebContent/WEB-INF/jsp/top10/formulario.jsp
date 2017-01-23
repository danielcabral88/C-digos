
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Registro de Top 10</h3>
	</div>
	<div class="panel-body">
		<form id="top10Form" action="<c:url value="/top10"/>" method="POST" >
			<div class="form-group">
				<label for="estacao">Estação</label> 
				<select id="estacao" name="top10.estacao.id" class="form-control">
					<option value="">Selecione uma Estação</option>
					<c:forEach items="${estacaoList}" var="estacao">
						<option value="${estacao.id}">${estacao.nome}</option>
					</c:forEach>
				</select> <br /> 
			</div>
			<div class="form-group">
				<label for="dia">Data Referência</label> <input
					id="dia" type="text" class="form-control"
					name="top10.dia" value="${top10.dia}" />
			</div>
			<div class="form-group">
				<label for="musica">Música 1</label> 
				<select id="musica" name="musicas.id.id" class="form-control">
					<option value="">Selecione uma Música</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">Música 2</label> 
				<select id="musica" name="musicas.id.id" class="form-control">
					<option value="">Selecione uma Música</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">Música 3</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma Música</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">Música 4</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma Música</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">Música 5</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma Música</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">Música 6</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma Música</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">Música 7</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma Música</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">Música 8</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma Música</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">Música 9</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma Música</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">Música 10</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma Música</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			
			<button class="btn btn-default" type="submit">Cadastrar</button>
		</form>
	</div>

	<script>
		$(function(){
			var datepickerOptions = {
				dateFormat : 'dd/mm/yy',
				dayNames : [ 'Domingo', 'Segunda', 'Terça',
						'Quarta', 'Quinta', 'Sexta', 'Sábado' ],
				dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S',
						'S', 'D' ],
				dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua',
						'Qui', 'Sex', 'Sáb', 'Dom' ],
				monthNames : [ 'Janeiro', 'Fevereiro', 'Março',
						'Abril', 'Maio', 'Junho', 'Julho',
						'Agosto', 'Setembro', 'Outubro',
						'Novembro', 'Dezembro' ],
				monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr',
						'Mai', 'Jun', 'Jul', 'Ago', 'Set',
						'Out', 'Nov', 'Dez' ],
				nextText : 'Próximo',
				prevText : 'Anterior',
				showOtherMonths : true,
				selectOtherMonths : true
			};
			
			$("#dia").datepicker(datepickerOptions);
			$("#btnAdicionarItem").bind("click", function() {
				alert("Inserindo musica na listagem");
			});
		});
	</script>
</div>
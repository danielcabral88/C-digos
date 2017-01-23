
<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Registro de Top 10</h3>
	</div>
	<div class="panel-body">
		<form id="top10Form" action="<c:url value="/top10"/>" method="POST" >
			<div class="form-group">
				<label for="estacao">Esta��o</label> 
				<select id="estacao" name="top10.estacao.id" class="form-control">
					<option value="">Selecione uma Esta��o</option>
					<c:forEach items="${estacaoList}" var="estacao">
						<option value="${estacao.id}">${estacao.nome}</option>
					</c:forEach>
				</select> <br /> 
			</div>
			<div class="form-group">
				<label for="dia">Data Refer�ncia</label> <input
					id="dia" type="text" class="form-control"
					name="top10.dia" value="${top10.dia}" />
			</div>
			<div class="form-group">
				<label for="musica">M�sica 1</label> 
				<select id="musica" name="musicas.id.id" class="form-control">
					<option value="">Selecione uma M�sica</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">M�sica 2</label> 
				<select id="musica" name="musicas.id.id" class="form-control">
					<option value="">Selecione uma M�sica</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">M�sica 3</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma M�sica</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">M�sica 4</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma M�sica</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">M�sica 5</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma M�sica</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">M�sica 6</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma M�sica</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">M�sica 7</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma M�sica</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">M�sica 8</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma M�sica</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">M�sica 9</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma M�sica</option>
					<c:forEach items="${musicaList}" var="musica">
						<option value="${musica.id}">${musica.nome} - ${musica.artista}</option>
					</c:forEach>
				</select> 
			</div>
			<div class="form-group">
				<label for="musica">M�sica 10</label> 
				<select id="musica" name="musicas.id" class="form-control">
					<option value="">Selecione uma M�sica</option>
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
				dayNames : [ 'Domingo', 'Segunda', 'Ter�a',
						'Quarta', 'Quinta', 'Sexta', 'S�bado' ],
				dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S',
						'S', 'D' ],
				dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua',
						'Qui', 'Sex', 'S�b', 'Dom' ],
				monthNames : [ 'Janeiro', 'Fevereiro', 'Mar�o',
						'Abril', 'Maio', 'Junho', 'Julho',
						'Agosto', 'Setembro', 'Outubro',
						'Novembro', 'Dezembro' ],
				monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr',
						'Mai', 'Jun', 'Jul', 'Ago', 'Set',
						'Out', 'Nov', 'Dez' ],
				nextText : 'Pr�ximo',
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
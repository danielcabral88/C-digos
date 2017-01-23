<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Editar Perfil</h3>
	</div>
	<div class="panel-body">
		<form action="<c:url value="/perfis/${perfil.id }"/>" method="POST">
			<div class="form-group">
				<label for="nome">Nome do Perfil</label> <input id="nome"
					type="text" class="form-control" name="perfil.nome"
					value="${perfil.nome}" /><br />
			</div>
			<button type="submit" class="btn btn-default" name="_method"
				value="PUT">Enviar</button>
		</form>
	</div>
</div>
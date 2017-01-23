<div class="panel panel-default">
	<div class="panel-heading">
		<h3 class="panel-title">Cadastro de Usuário</h3>
	</div>
	<div class="panel-body">
		<form id="usuariosForm" action="<c:url value="/usuarios"/>"
			method="POST">
			<div class="form-group">
				<label for="nome">Nome do Usuário</label> <input id="nome"
					type="text" class="form-control" name="usuario.nome" value="${usuario.nome}" />
			</div>
			<div class="form-group">
				<label
					for="perfil">Perfil do Usuário</label> <select id="perfil" class="form-control"
					name="usuario.perfil.id">
					<option value="">Selecione um perfil</option>
					<c:forEach items="${perfilList}" var="perfil">
						<option value="${perfil.id}">${perfil.nome}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="login">Login</label> <input id="login"
					type="text" class="form-control" name="usuario.login" value="${usuario.login}" />
			</div>
			<div class="form-group">
				<label for="senha">Senha</label> <input id="senha" type="password" class="form-control" 
					name="usuario.senha" value="${usuario.senha}" />
			</div>
			<button type="submit" class="btn btn-default">Enviar</button>
		</form>
	</div>
</div>
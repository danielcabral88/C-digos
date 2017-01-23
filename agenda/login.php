<?php include("logica-usuario.php"); ?>			

<div>
<div class="col-xs-14 col-sm-7 col-lg-7">
			<h1 class="page-header">
				Bem vindo!</h1>					
					</div>
				<div class="col-xs-10 col-sm-5 col-lg-5">

<h2> Login </h2>
<?php 
    if ( usuarioEstaLogado() ) {
?>



       <p class="alert-success">
       	   Você está logado como <?= usuarioLogado() ?>
<a href="logout.php"> [Sair]</a>
       	</p>
<?php
    } else {
?>
	

<form action="logar.php" method="post">
	<table class="table">
		<tr>
			<td>Medico</td>
			<td><input class="form-control" type="text" name="name">  </td>
		</tr>
		<tr>
			<td>Senha</td>
			<td><input class="form-control" type="password" name="senha">  </td>
		</tr>
		<tr>
			<td></td>
			<td><a href="medico-cadastrar.php">cadastrar</a> </td>
		</tr>
		<tr>
			<td><button type="submit" class="btn btn-primary">Login</button></td>
		</tr>	
	</table>
</form>

<?php 
  } 
?>
</div>
		

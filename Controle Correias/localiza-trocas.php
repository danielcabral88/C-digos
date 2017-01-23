<?php 
include("cabecalho.php");
include("conecta.php");
?>

<div class="container-fluid">
        <h2></h2>
        <div class="row">
            <div class="col-sm-4">    
            </div>
            <div class="col-sm-4">
                <h3>Localizador</h3>
                <form action = "lista-trocas.php" method ="post">
                        <div class="form-group">
                          <input type="text" class="form-control" name="tag" placeholder="Digite o TAG">
                        </div>
                        <button type="submit" class="btn btn-default">Buscar</button>  
                </form>    
            </div>
            <div class="col-sm-4">    
            </div>
        </div>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<?php include("rodape.php") ?>
<?php 
include("cabecalho.php");
include("conecta.php");
include("DAO-Troca.php");
?>

<div class="container-fluid">

        <div class="row">

            <div class="col-sm-4"></div>

            <div class="col-sm-4">
                <?php  
                 $tag = $_POST['tag'];
                 $listaTrocas = ListaTrocasTag($conexao, $tag);
                ?>
                <h3>Localizador</h3>
                <form action = "lista-trocas.php" method ="post">
                    <div class="form-group">
                        <input type="text" class="form-control" name="tag" value = "<?=$tag?>" placeholder="Digite o TAG"/>
                    </div>
                    <button type="submit" class="btn btn-default">Buscar</button>  
                </form>
                <div class = "table-responsive">
                    <table class= "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Data</td>
                                <th>Abrir</td>
                            </tr>
                        </thead>
                            <tbody>
                            <?php foreach($listaTrocas as $troca) : ?>
                             <tr>
                                <td><?= $troca['data'] ?></td>
                                <td>
                                    <form action="detalhes-troca.php" method="post">
                                        <input type="hidden" name="id" value="<?= $troca['id'] ?>"/>
                                        <button class="btn btn-default">Abrir</button>
                                    </form>
                                </td> 
                            </tr>
                            <?php endforeach ?>
                            </tbody> 
                    </table>    
                </div>
            </div>

            <div class="col-sm-4"></div>

        </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<?php include("rodape.php") ?>
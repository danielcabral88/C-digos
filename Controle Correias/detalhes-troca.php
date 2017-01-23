<?php 
include("cabecalho.php");
include("conecta.php");
include("DAO-Troca.php");
include("DAO-DadosEmbarque.php");
?>

<div class="container-fluid">
        <h2></h2>
        <div class="row">
            <div class="col-sm-8">
                <?php  
                    $id = $_POST['id'];
                    $detalhesTroca = BuscaTroca($conexao, $id);
                    $navios = BuscarAtivoData($conexao, $detalhesTroca['ativo'], $detalhesTroca['data']);
                    $cargatotal = 0;
                ?>
                <h3>Resumo de Navios</h3>
                <div class = "table-responsive">
                    <table class = "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Navio</td>
                                <th>Data</td>
                                <th>Carga</td>
                            </tr>
                        </thead>
                        <tbody>
                        <?php foreach($navios as $navio) : ?>
                            <tr>
                                <td><?= $navio['nome_navio'] ?></td>
                                <td><?= $navio['data_desatracacao'] ?></td>
                                <td><?= $navio['carga'] ?></td>
                            </tr>
                        <?php 
                            $cargatotal = $cargatotal + $navio['carga'];
                            endforeach 
                        ?>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-sm-4">
                <h3>Dados da Troca</h3>
                <table class = "table table-striped table-bordered">
                    <thead>
                        <tr>
                            <th style = "text-align:left">Descrição</th>
                            <th style = "text-align:left">Dados</th>
                        </tr>   
                    </thead>
                    <tbody>
                        <tr>
                            <td>Data da Troca</td>
                            <td><?= $detalhesTroca['data'] ?></td>
                        </tr>
                        <tr>
                            <td>OS</td>
                            <td><?= $detalhesTroca['os'] ?></td>
                        </tr>
                        <tr>
                            <td>Custo</td>
                            <td>R$ <?= $detalhesTroca['custo'] ?></td>
                        </tr>
                        <tr>
                            <td>Carga Total</td>
                            <td><?= $cargatotal ?></td>
                        </tr>
                        <tr>
                            <td>Espessura Atual</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Média Histórica</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Operado x Média</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td>Observações</td>
                            <td><?= $detalhesTroca['obs'] ?></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>

</div>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<?php include("rodape.php") ?>
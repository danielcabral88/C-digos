<?php include("cabecalho.php"); 
        include ("conecta.php");
        include ("DAO/DAO-medicamento.php");
?>



  <div class="row">
                    <div class="col-lg-12">


                        <h1 class="page-header">
                           Medicamentos
                        </h1>
                      
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                    <ul class="nav nav-tabs" role="tablist">
                      <li class="active"><a href="#novo-medicamento" role="tab" data-toggle="tab">Cadastrar Medicamento</a></li>
                      <li><a href="#lista-medicamento" role="tab" data-toggle="tab">Listar Medicamentos</a></li>
                    </ul>
                    
                    <div class="tab-content">
                        <div class="tab-pane col-lg-6 active" id="novo-medicamento">
                            <br>
                            <form class="col-lg-9"  action="CRUD/add-medicamento.php" method="get">
                                    <label for="pacient-name">Nome do Medicamento</label>
                                    <br>
                                    <input class="form-control" type="text" id="medicamento" name="medicamento">
                                      <br>
                                      <button type="submit" class="btn btn-lg btn-primary" >Salvar Medicamento</button>
                                
                               
                                


                            </form>

                        </div>
                        <div class="tab-pane col-lg-6" id="lista-medicamento">
                            <div class="tab-pane col-lg-12 principal">
                                    <br>
                                    <br>
                           <table class="table table-striped table-bordered">
                                <tr>
                                      <th>Medicamentos</th>
                                      <th>Alterar</th>
                                 </tr>

                                <?php
                                    $medicamentos = ListaMedicamentos($conexao);
                                    foreach($medicamentos as $medicam) :
                                ?>
                                <tr>
                                    <td><?= $medicam['nome_medicamento'] ?></td>
                                    <td >
                                        <form action="CRUD\remover-medicamento.php" method="post">
                                            <input type="hidden" name="id" value="<?=$medicam['idMedicamento']?>">
                                            <button class="btn btn-danger">remover</button>
                                        </form>
                                      </td>
                                </tr>
                            <?php
                              endforeach
                            ?>
                           </table>
                        </div>
                    </div>
                    </div>
                    
                </div>
                <!-- /.row -->


<?php include("rodape.php") ?>
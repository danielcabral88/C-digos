<?php include ("cabecalho.php"); 
        include ("conecta.php");
        include ("DAO/DAO-medicamento.php");?>

  <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           Prescrição
                        </h1>
                      
                    </div>
                </div>
                <!-- /.row -->
                <div class="row col-lg-12">
                   
                
                         <br>
                            <form action="crud/add-prescricao.php" method="get">
                                <div class = "col-lg-9">
                                    <div class="form-group">
                                        <label for="nome-exame">Nome do Medicamento</label>
                                            <input  class="form-control" type="text" name="medicamento" id="srch" list="datalist1" />
                                            <datalist id="datalist1">
                                            
                                                <?php
                                                $medicamentos = ListaMedicamentos($conexao);
                                                foreach($medicamentos as $medicam) :
                                                ?>
                                            <option value="<?= $medicam['nome_medicamento'] ?>"> 
                                              <?php    endforeach ?>
                                            </datalist>
                                     
                                        
                                    </div>

                                    <div class="form-group">
                                        <label for="dosagem">Dosagem</label>
                                        <input class="form-control" type="text" name="dosagem" id="dosagem">
                                    </div>
                                    <div class="form-group">
                                        <label for="dias">Administração</label>
                                        <input class="form-control" type="text" name="administracao" id="administraçao">
                                    </div>
                                	 <div class="form-group">
                                        <label for="dias">Tempo de uso</label>
                                        <input class="form-control" type="text" name="tempoUso" id="tempoUso">
                                    </div>
                                   
                                </div>
                                <br>
                                    <div class="form-group col-lg-3">
                                
                                   <button type="submit" class="btn btn-lg btn-primary">Salvar Prescrição</button>
                                </div>

                            </form>

                           
                              
                            
                       
                    
                </div>
                <!-- /.row -->





<?php include ("rodape.php"); ?>
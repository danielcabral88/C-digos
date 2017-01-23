<?php include ("cabecalho.php"); ?>

  <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                           Configuraçoes
                        </h1>
                      
                    </div>
                </div>
                <!-- /.row -->
                <div class="row col-lg-12">
                   
                  
                         <br>
                            <form class = "col-lg-9">

                                <div class="form-group">
                                    <label for="medico">Medico</label>
                                    <input class="form-control" type="text" id="medico">
                                </div>
                                <div class="form-group">
                                    <label for="medico-Crm">Crm</label>
                                    <input class="form-control" type="text" id="crm">
                                </div>
                                <div class="form-group">
                                    <label for="dias">Dias de trabalho</label>
                                    <input class="form-control" type="number" id="diaSemana">
                                </div>
                            	 <div class="form-group">
                                    <label for="dias">Horario Inicio de Expediente</label>
                                    <input class="form-control" type="time" id="horarioInicio">
                                </div>
                                <div class="form-group">
                                    <label for="dias">Horario Fim de Expediente</label>
                                    <input class="form-control" type="time" id="horariofinal">
                                </div>
                                <div class="form-group">
                                    <label for="dias">Duração da consulta</label>
                                    <input class="form-control" type="number" id="diaSemana">
                                </div>
                                <div class="form-group">
                                    <label for="dias">Limite de Encaixes</label>
                                    <input class="form-control" type="number" id="limiteEncaixe">
                                </div>
                               
                            


                            </form>

                           
                              <br>
                                    <div class="form-group">
                                
                                   <button type="button" class="btn btn-lg btn-primary">Salvar Configurações</button>
                                </div>
                            
                       
                    
                </div>
                <!-- /.row -->




<?php include("rodape.php"); ?>

<?php  

/*
* Classe de conexão a banco de dados MySQL Orientado a Objetos
* 
*/
class BancoDeDados{

	private static $instance = null;
	private $conn;

	private function __construct(){
		 $host = "localhost";
	 	 $bd = "lojalivros";
		 $usuario = "";
	 	 $senha = "";

	 	 try{
	 	 	$this->conn = mysqli_connect($host, $usuario, $senha, $bd);
	 	 	$this->conn->set_charset('utf8');
	 	 }catch(Exception $e){
	 	 	die("Erro na conexão com o banco... ".$e->getMessage());
	 	 }
	}

	static function getInstance(){
		if($instance == NULL) $instance = new BancoDeDados();
		return $instance;
	}
	


	public function selecionarDB(){
		$banco = mysql_select_db($this->db) or die($this->mensagem(mysql_error()));
		if($banco){
			return true;
		}else{
			return false;
		}
	}

	public function executar($sql){
		$query = mysql_query($sql) or die ($this->mensagem(mysql_error()));
		return $query;
	}

	public function mensagem($erro){
		echo $erro ;
	}
}

// Usando a classe
//$db = BancoDeDados::getInstance();
//$db->executar();
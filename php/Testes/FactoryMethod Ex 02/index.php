<?php
//Client.php
include_once('CountryFactory.php');
include_once('BrasilProduct.php');
class Client{
	private $countryFactory;
	public function _construct(){
		$this->countryFactory=new CountryFactory();
		echo $this->countryFactory->doFactory(new BrasilProduct());
	}
}
$worker=new Client();
$worker->_construct();
?>
